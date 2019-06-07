<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link type="text/css" rel="stylesheet" href="css/signUp.css">
<script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="js/signUp.js"></script>

<%@ include file="neck.jsp"%>
<%
	String context = request.getContextPath();
    System.out.println("context->"+context);
%>
<hr>
<form action="signUpProView.do">
	<div class="signUpBox">
		<h1>회원가입</h1>
		<hr><br>
		<label>아이디</label><br>
		<input class="input" id="id" type="text" placeholder="Enter ID" onkeypress="idLengthCheck()" name="id" 
			maxlength="16" required><button type="button" onclick="idDuplicate()">중복확인</button><br>
		<span id="msgIdLengthCheck" class="idCheckMsg"></span><br>
		<span id="msgIdDuplCheck" class="idCheckMsg"></span><br>
		<label>Email</label><br>
		<input class="input" type="email" placeholder="Enter Email" name="email" required><br><br><br>
		<label>닉네임</label><br>
		<input class="input" id="nicName" type="text" placeholder="Enter Nicname" 
			name="nicName" required><button type="button" onclick="nicDuplicate()">중복확인</button><br>
		<span id="msgNicDuplCheck" class="idCheckMsg"></span><br><br>
		<label>패스워드</label><br>
		<input class="input" type="password" placeholder="Enter Password" name="pw" required><br><br><br>
		<label>패스워드 확인</label><br>
		<input class="input" type="password" placeholder="Repeat Password" name="pw-repeat" required><br>
		<hr><br>
		<input class="regiBtn" type="submit" value="가입">
	</div>
</form>
</body>
</html>
<br>
<br>
<%@ include file="footer.jsp" %>