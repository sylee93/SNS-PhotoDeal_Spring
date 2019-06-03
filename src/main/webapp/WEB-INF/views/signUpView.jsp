<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link type="text/css" rel="stylesheet" href="css/signUp.css">

<%@ include file="neck.jsp"%>
<hr>
<form action="/action_page.php">
	<div class="signUpBox">
		<h1>회원가입</h1>
		<hr><br>
		<label>아이디</label><br>
		<input class="input" type="text" placeholder="Enter ID" name="id" required><button>중복확인</button><br><br>
		<label>Email</label><br>
		<input class="input" type="email" placeholder="Enter Email" name="email" required><br><br>
		<label>패스워드</label><br>
		<input class="input" type="password" placeholder="Enter Password" name="psw" required><br><br>
		<label>패스워드 확인</label><br>
		<input class="input" type="password" placeholder="Repeat Password" name="psw-repeat" required><br>
		<hr><br>
		<input class="regiBtn" type="submit" value="가입">
	</div>
</form>

</body>
</html>
<br>
<br>
<%@ include file="footer.jsp"%>