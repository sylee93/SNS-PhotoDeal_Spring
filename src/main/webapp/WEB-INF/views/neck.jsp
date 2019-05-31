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
				<a href="#">유료 이미지</a> <a href="#">무료 이미지</a> <a href="#">카테고리</a>
			</div>
		</div>
		<c:if test="${session.id == null }">
			<div class="profile">
				<button class="menubtn" onclick="openLogin()">
					<img src="image/login.png">
				</button><br>
				<div class="profile-content">
					<a href="#">유료 이미지</a><a href="#">무료 이미지</a><a href="#">카테고리</a>
				</div>
			</div>
		</c:if>
		<c:if test="${session.id != null }">
			<button class="menubtn right" onclick="mySideBar()">
				<img src="image/login.png">
			</button>
			<div class="menu-content">
				<a href="#">유료 이미지</a><a href="#">무료 이미지</a><a href="#">카테고리</a>
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
	<div class="sortdiv">
		<button class="sortbtn">
			<b>최신 순</b>
		</button>
		<button class="sortbtn">
			<b>인기 순</b>
		</button>
		<button class="sortbtn">
			<b>다운로드 순</b>
		</button>
	</div>
	<div id="myOverlay" class="overlay">
		<span class="closebtn" onclick="closeLogin()" title="Close Overlay">X</span>
		<div class="overlay-content">
			<form action="#">
				<div class="logo">
					<img src="image/title2.png">
				</div>
				<label>ID</label><br> <input type="text" name="id"><br>
				<br> <label>Password</label><br> <input type="text"
					name="password"><br> <br> <input type="submit"
					value="로그인"> <a class="signup" href="signUpView.do">회원가입</a>
			</form>
		</div>
	</div>