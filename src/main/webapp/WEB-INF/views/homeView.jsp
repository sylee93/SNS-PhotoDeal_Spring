<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link type="text/css" rel="stylesheet" href="css/homeView.css">
<%@ include file="neck.jsp"%>
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
<hr class="bodystart">
<div class="column">
	<figure>
		<img src="image/test1.jpg">
	</figure>
	<figure>
		<img src="image/test2.jpg">
	</figure>
	<figure>
		<img src="image/test3.jpg">
	</figure>
	<figure>
		<img src="image/test4.jpg">
	</figure>
	<figure>
		<img src="image/test5.jpg">
	</figure>
	<figure>
		<img src="image/test6.jpg">
	</figure>
	<figure>
		<img src="image/test7.jpg">
	</figure>
	<figure>
		<img src="image/test8.jpg">
	</figure>
	<figure>
		<img src="image/test9.jpg">
	</figure>
	<figure>
		<img src="image/test10.jpg">
	</figure>
	<figure>
		<img src="image/test12.jpg">
	</figure>
	<figure>
		<img src="image/test13.jpg">
	</figure>
	<figure>
		<img src="image/test14.jpg">
	</figure>
	<figure>
		<img src="image/test15.jpg">
	</figure>
	<figure>
		<img src="image/test16.jpg">
	</figure>
	<figure>
		<img src="image/test17.jpg">
	</figure>
	<figure>
		<img src="image/test18.jpg">
	</figure>
	<figure>
		<img src="image/test19.jpg">
	</figure>
	<figure>
		<img src="image/test20.jpg">
	</figure>
</div>
<c:if test="${checkResult == 'failPw'}">
	<script type="text/javascript">
		alert("비밀번호가 올바르지 않습니다.");  
		location.href="homeView.do";
	</script>
</c:if> 
<c:if test="${checkResult == 'failId'}">
	<script type="text/javascript">
		alert("존재하지 않는 아이디입니다.");  
		location.href="homeView.do";
	</script>
</c:if> 
<%@ include file="footer.jsp"%>

