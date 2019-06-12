<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link type="text/css" rel="stylesheet" href="css/signUp.css">
<script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
<!-- <script src="js/signUp.js"></script> -->

<%@ include file="neck.jsp"%>
<%
	String context = request.getContextPath();
    System.out.println("context->"+context);
%>
<hr>
<form action="signUpProView.do" name="frm" onsubmit="return chk()" enctype="multipart/form-data" method="POST" >
	<div class="signUpBox">
		<h1>회원가입</h1>
		<hr><br>
		<div id="preview" class="sugnUpProfile">
			<img src="image/user.png">
		</div><br>
		<label>아이디</label><br>
		<input class="input" id="id" type="text" placeholder="Enter ID" onkeyup="idCheck(this)" name="id" 
			maxlength="16" autocomplete="off" required><br>
		<span id="msgIdCheck" class="checkMsg"></span><br>
		
		<label>프로필</label><br>
		<input class="input" id="profilePath" name="profilePath" type="file" onchange="fileCheck()" accept='image/jpeg,image/gif,image/png' ><br><br>
		<input type="hidden" name="path" value="${pageContext.request.contextPath}/resources/image/">
		
		<label>Email</label><br>
		<input class="input" id="email" type="email" placeholder="Enter Email" name="email" autocomplete="off" 
		required><button type="button" onclick="mailCheck()">중복확인</button><br>
		<span id="msgMailCheck" class="checkMsg"></span><br>
		
		<label>닉네임</label><br>
		<input class="input" id="nicName" type="text" placeholder="Enter Nicname" onkeyup="nicCheck()"
			name="nicName" autocomplete="off" required>
		<span id="msgNicCheck" class="checkMsg"></span><br><br>
		
		<label>패스워드</label><br>
		<input class="input" type="password" maxlength="16" placeholder="Enter Password" name="pw" autocomplete="off" ><br><br>
		
		<label>패스워드 확인</label><br>
		<input class="input" type="password" maxlength="16" placeholder="Repeat Password" name="repeatPw" autocomplete="off" required><br>
		<hr><br>
		<span id="msgPwCheck" class="checkMsg"></span><br><br>
		
		<input class="regiBtn" type="submit"  value="가입">
	</div>
</form>


<script>
var rmImg = document.getElementById('preview');
var upload = document.querySelector('#profilePath');
 /* FileReader 객체 생성 */
var reader = new FileReader();
    /* reader 시작시 함수 구현 */
reader.onload = (function () {
    this.image = document.createElement('img');
    var vm = this;  
    return function (e) {
        /* base64 인코딩 된 스트링 데이터 */
        vm.image.src = e.target.result
    }
})()
upload.addEventListener('change',function (e) {
    var get_file = e.target.files;
    if(get_file){
        reader.readAsDataURL(get_file[0]);
    }
    preview.appendChild(image);
})
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
function fileCheck(){
	var val = document.getElementById("profilePath").value;
	var baseImg = document.createElement("img");
	var point = val.lastIndexOf('.');
	var tempFileType = val.substring(point+1, val.length);
	var fileType = tempFileType.toUpperCase()
	if (val != ""){
		while(rmImg.firstChild) {
	   		rmImg.removeChild(rmImg.firstChild);
		}
	} else {
		while(rmImg.firstChild) {
	   		rmImg.removeChild(rmImg.firstChild);
		}
		baseImg.setAttribute("src", "image/user.png");
		document.getElementById("preview").appendChild(baseImg);
	}
	if(fileType=='JPG'||fileType=='GIF'||fileType=='PNG'||fileType=='JPEG'||fileType=='BMP' || fileType==null){
		return true;
	} else {
		alert("이미지 파일(JPG, GIF, PNG, JPEG, BMP)만 등록가능 합니다.")
		frm.profilePath.value = "";
		return false;
	}
}

function idCheck(obj){
	obj.value = obj.value.replace(/[\!\@\#\$\%\^\&\*\(\)\_\-\=\+\|\\\.\,\;\`\~\"\'\[\]\{\}\?\>\<\/\:\ㄱ-ㅎㅏ-ㅣ가-힣]/g,'');
	var idCheckMsg = document.getElementById("msgIdCheck").innerHTML;
	$.ajax({
		url:"<%=context%>/user/idCheck.do",
		type:"POST",
		data : {id : $('#id').val()},
		dataType:'text',
		success: function(checkMsg){
			if (idCheckMsg != "사용 가능한 아이디 입니다."){
				document.getElementById("msgIdCheck").className = "checkMsg";
			} else {
				document.getElementById("msgIdCheck").className = "checkGreenMsg";
			}
			$('#msgIdCheck').html(checkMsg);
		}
	})
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
function mailCheck(){
	var mailCheckMsg = document.getElementById("msgNicCheck").innerHTML;
	$.ajax({
		url:"<%=context%>/user/mailCheck.do",
		type:"POST",
		data : {"email" : $('#email').val()},
		dataType:'text',
		success: function(mailCheckMsg){
			if (mailCheckMsg == "사용 가능한 Email 입니다."){
				document.getElementById("msgMailCheck").className = "checkGreenMsg";
			} else {
				document.getElementById("msgMailCheck").className = "checkMsg";
			}
			$('#msgMailCheck').html(mailCheckMsg);
		}
	})
}	

</script>
<c:if test="${userCheck == 'sameId'}">
	<script type="text/javascript">
		alert("중복된 아이디가 존재합니다.");
	</script>
</c:if> 
<c:if test="${userCheck == 'sameNic'}">
	<script type="text/javascript">
		alert("중복된 닉네임이 존재합니다.");  
	</script>
</c:if>
<c:if test="${userCheck == 'sameEmail'}">
	<script type="text/javascript">
		alert("중복된 E-mail이 존재합니다.");  
	</script>
</c:if>  
</body>
</html>
<br>
<br>
<%@ include file="footer.jsp" %>