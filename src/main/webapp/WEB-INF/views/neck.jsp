<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link type="text/css" rel="stylesheet" href="css/login.css">
<title>syProject</title>
</head>
<body>
	<nav>
		<c:if test="${sessionScope.member.id == null }">
			<div class="profile">
				<button class="menubtn right" onclick="openLogin()">
					<img src="image/login.png">
				</button>
			</div>
		</c:if>
		<c:if test="${sessionScope.member.id != null }">
			<div class="profile">
				<button class="menubtn right">
					<div class="profile-box">
						<img src="upload/${sessionScope.member.profile }">
					</div>
				</button>
				<div class="profile-content">
					<a href="#">
						보유포인트<br>
						${sessionScope.member.point }
					</a>
					<hr class="myinfoHr">
					<a href="myInfoView.do">
						상세보기
					</a>
					<a href="homeView.do?logOutFlag=1">로그아웃</a>
				</div>
			</div>
		</c:if>

		<div class="title">
			<a href="homeView.do"><img src="image/title2.png"></a>
		</div>
		<div class="searchNav">
			<select class="neckSerchFilter">
				<option value="filterTag">태그검색</option>
				<option value="filterUser">유저검색</option>
			</select> <input class="search bar" type="text" placeholder="Search...">
			<button class="search btn">
				<img class="dodbogi" src="image/dodbogi.png">
			</button>
		</div>
	</nav>
	<div id="myOverlay" class="overlayLogin">
		<span class="closebtn" onclick="closeLogin()" title="Close Overlay">X</span>
		<div class="overlay-content">
			<form action="homeView.do">
				<div class="logo">
					<img src="image/title2.png">
				</div>
				<label>ID</label><br> 
				<input type="text" name="id"><br><br>
				<label>Password</label><br> 
				<input type="text" name="pw"><br> <br> 
				<input type="submit" value="로그인"> 
				<a class="signup" href="signUpView.do">회원가입</a>
			</form>
		</div>
	</div>