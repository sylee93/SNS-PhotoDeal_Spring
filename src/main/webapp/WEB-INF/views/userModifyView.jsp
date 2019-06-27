<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/signUp.css">

<%@ include file="neck.jsp"%>
<%@ include file="myPageSideBar.jsp"%>
<%
	String context = request.getContextPath();
    System.out.println("context->"+context);
%>

<div id="main">
	<form action="myPageView.do" name="frm" onsubmit="return chk()" method="POST">
	<input type="hidden" name="myPageStatus" value="userModi">
		<div class="signUpBox">
			<h1>회원정보 수정</h1><hr><br> 
			<label>아이디</label><br> <input class="input readOnly" id="id" type="text" placeholder="Enter ID" onkeyup="idCheck(this)" name="id"
				maxlength="16" autocomplete="off" value="${sessionScope.member.id }" readonly="readonly"><br><br> 
			
			<label>Email</label><br>
			<input class="input readOnly" id="email" value="${sessionScope.member.email }" type="text" placeholder="Enter Email" name="email" 
			autocomplete="off" readonly="readonly"><br><br>
			
			<label>닉네임</label><br>
			<input class="input" id="nicName" value="${sessionScope.member.nicName }" type="text"
				placeholder="Enter Nicname" onkeyup="nicCheck()" name="nicName" autocomplete="off" required> 
			<span id="msgNicCheck" class="checkMsg"></span><br><br> 
		
			<label>현재 패스워드</label><br>
			<input class="input" type="password" maxlength="16"	placeholder="Enter Password" name="beforePw" autocomplete="off"><br><br>
			
			<label>변경할 패스워드</label><br>
			<input class="input" type="password" maxlength="16"	placeholder="Enter Password" name="pw" autocomplete="off"><br><br>
		
			<label>패스워드 확인</label><br> 
			<input class="input" type="password" maxlength="16" placeholder="Repeat Password" name="repeatPw" autocomplete="off" required><br>
		
			<hr><br>
			<span id="msgPwCheck" class="checkMsg"></span><br> <br>
			<input class="regiBtn" type="submit" value="수정완료">
		</div>
	</form>
<script>

function chk(){
	if(frm.pw.value!=frm.repeatPw.value) {
		alert("비밀번호가 일치하지 않습니다.");
		frm.pw.focus();
		frm.pw.value = "";
		frm.repeatPw.value = "";
		return false;
	}
	return true;
}

function nicCheck(){
	var nicCheckMsg = document.getElementById("msgNicCheck").innerHTML;
	$.ajax({
		url:"<%=context%>/user/nicCheck.do",
		type:"POST",
		data : {nicName : $('#nicName').val(), id : $('#id').val()},
		dataType:'text',
		success: function(nicCheckMsg){
			if (nicCheckMsg == "사용 가능한 닉네임 입니다."){
				document.getElementById("msgNicCheck").className = "checkGreenMsg";
			} else {
				document.getElementById("msgNicCheck").className = "checkMsg";
			}
			$('#msgNicCheck').html(nicCheckMsg);
		}
	})
}

</script>
<c:if test="${resultPw == 'failPwCheck'}">
	<script type="text/javascript">
		alert("현재 비밀번호가 올바르지 않습니다.");  
	</script>
</c:if>  

</div>
<%@ include file="footer.jsp"%>

