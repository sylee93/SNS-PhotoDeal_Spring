
<hr>
<form action="signUpProView.do" name="frm" onsubmit="return chk()" enctype="multipart/form-data" method="POST" >
	<div class="signUpBox">
		<h1>회원정보 수정</h1>
		<hr><br>
		<div id="preview" class="sugnUpProfile">
			<img src="image/user.png">
		</div><br>
		<label>아이디</label><br>
		<input class="input" id="id" type="text" placeholder="Enter ID" onkeyup="idCheck(this)" name="id" 
			maxlength="16" autocomplete="off" value="" readonly="readonly"><br>
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
