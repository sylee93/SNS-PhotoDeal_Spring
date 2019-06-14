<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link type="text/css" rel="stylesheet" href="css/homeView.css">
<!-- <script type="text/javascript" src="js/homeView.js"></script> -->
<%@ include file="neck.jsp"%>
<%
	String context = request.getContextPath();
%>
<input id="btnStatus" type="hidden" value="${btnStatus }">
<div id="sortdiv" class="sortdiv">
	<a id="lateBtn" class="sortbtn active" href="homeView.do?sortType=0">
		<b>최신 순</b>
	</a> <a id="likeBtn" class="sortbtn" href="homeView.do?sortType=1"> <b>인기
			순</b>
	</a> <a id="downBtn" class="sortbtn" href="homeView.do?sortType=2"> <b>다운로드
			순</b>
	</a>
</div>
<hr class="bodystart">
<div class="column">
	<c:forEach var="photoList" items="${PhotoList}">
		<figure>
			<img src="image/${photoList.photoPath }">
		</figure>
	</c:forEach>
</div>
<script type="text/javascript">
	var btnContainer = document.getElementById("sortdiv");
	var btns = btnContainer.getElementsByClassName("sortbtn");

	if ($("#btnStatus").value() == 0) {
		document.getElementById("lateBtn").className = "sortbtn active";
		document.getElementById("likeBtn").className = "sortbtn";
		document.getElementById("downBtn").className = "sortbtn";
	} else if ($("#btnStatus").value() == 1) {
		document.getElementById("lateBtn").className = "sortbtn";
		document.getElementById("likeBtn").className = "sortbtn active";
		document.getElementById("downBtn").className = "sortbtn";
	} else {
		document.getElementById("lateBtn").className = "sortbtn";
		document.getElementById("likeBtn").className = "sortbtn";
		document.getElementById("downBtn").className = "sortbtn active";
	}
</script>
<c:if test="${checkResult == 'failPw'}">
	<script type="text/javascript">
		alert("비밀번호가 올바르지 않습니다.");
		location.href = "homeView.do";
	</script>
</c:if>
<c:if test="${checkResult == 'failId'}">
	<script type="text/javascript">
		alert("존재하지 않는 아이디입니다.");
		location.href = "homeView.do";
	</script>
</c:if>
<%@ include file="footer.jsp"%>

