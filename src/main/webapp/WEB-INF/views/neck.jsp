<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link type="text/css" rel="stylesheet" href="css/login.css">
<title>syProject</title>
</head>
<body>
	<nav>
		<div class="menu">
			<button class="menubtn">
				<img src="image/menu.png">
			</button>
			<div class="menu-content">
				<a href="#">유료 이미지</a> <a href="#">무료 이미지</a> <a href="categoryView.do">카테고리</a>
			</div>
		</div>
		<c:if test="${session.id == null }">
			<div class="profile">
				<button class="menubtn right" onclick="openLogin()">
					<img src="image/login.png">
				</button>
			</div>
		</c:if>
		<c:if test="${session.id != null }">
			<div class="profile">
				<button class="menubtn right" onclick="openLogin()">
					<img src="image/login.png">
				</button>
				<div class="profile-content">
					<a href="#">
						보유포인트<br>
						50,000원
					</a>
					<hr class="myinfoHr">
					<a href="myPageView.do">
						상세보기
					</a>
					<p>로그아웃</p>
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