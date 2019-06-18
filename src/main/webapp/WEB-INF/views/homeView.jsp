<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link type="text/css" rel="stylesheet" href="css/homeView.css">
<script type="text/javascript" src="js/homeView.js"></script>
<script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
<%@ include file="neck.jsp"%>
<%
	String context = request.getContextPath();
%>
<input id="btnStatus" type="hidden" value="${btnStatus } ">
<div id="sortdiv" class="sortdiv" >
	<a id="lateBtn" class="sortbtn active" href="homeView.do?sortType=0"><b>최신 순</b></a>
	<a id="likeBtn" class="sortbtn" href="homeView.do?sortType=1"> <b>인기 순</b></a>
	<a id="downBtn" class="sortbtn" href="homeView.do?sortType=2"> <b>다운로드 순</b></a>
</div>
<hr class="bodystart">
<div class="column">
	<c:forEach var="photoList" items="${photoList}">
		<div class="container">
			<img class="columnImg" src="image/${photoList.photoPath }">
			<div class="overay" onclick="location.href='detailPhotoView.do?photoId=${photoList.photoId}'">
				<div class="overayContent">
					<div class="contentTop">		
						<span class="count">
							<img src="image/download2.png" alt="down">
							${photoList.downloadCount }
						</span>
						<span class="count">
							<img src="image/view.png" alt="view">
							${photoList.viewCount }
						</span>
						<div id="right" class="count">
							<img src="image/heart.png" alt="like">
							${photoList.likeCount }
						</div>
						<c:if test="${photoList.priceStatus == 1}">
							<div class="coin">
								<img src="image/coin.png"><br>
							</div>
						</c:if>
					</div>
					<br><br>
					<div class="contentBottom">
						<p class="contentText">${photoList.hashTag }</p>
						<hr class="homeVieHr">
						<div class="creatorBox">
							<div class="creator">
								<img src="upload/${photoList.profile}">
							</div>
							${photoList.nicName}
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
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

