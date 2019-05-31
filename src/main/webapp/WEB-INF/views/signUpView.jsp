<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<style>
.signUpBox {
	width: 40%;
	margin: 0 auto;
	margin-top: 5%;
}
.signUpBox label{
	font-size: 1.2rem;
	font-weight: bold;
	color: #706f6f;
}
.signUpBox input[type = ] {
	width : 100%;
	height: 30px;
}
.signUpBox input[name=id] {
	width: 80%;
}
.signUpBox button{
	width : 20%;
	border:none;
}
.signUpBox input{
	width: 100%;
}
.input {
	height: 30px;
	border: none;
	background-color: #fff0f0;
	opacity: 0.8;
	padding-left: 5px;
}
.signUpBox button {
	height: 30px;
	background-color: #f47f7f;
	color: white;
	opacity: 0.8;
}
.regiBtn{
	margin: 0 auto;
	border:none;
	background-color: #f47f7f;
	height : 50px;
	font-weight: bold;
	font-size: 2rem;
	color: white;
	opacity: 0.8;
}
.input:hover  {
	opacity: 1;
}
.regiBtn:hover {
	opacity: 1;
}
.signUpBox button:hover {
	opacity: 1;
}

</style>

<%@ include file="neck.jsp"%>

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