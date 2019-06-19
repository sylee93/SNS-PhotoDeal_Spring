<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/detailPhoto.css">
<script type="text/javascript" src="js/detailPhoto.js"></script>
<%@ include file="neck.jsp"%>
<div class="main">
	<div>
		<span class="count"> <img src="image/greyView.png" alt="view">
			${photo.viewCount }
		</span> 
		<span class="count"> <img src="image/download.png" alt="down">
			${photo.downloadCount }
		</span> 
		<span class="count"> <img src="image/greyHeart.png" alt="like">
			${photo.likeCount }
		</span>
	</div>
	<div class="mainPhoto">
		<img src="image/${photo.photoPath }">
	</div>
	<div class="photoBtn">
		<c:if test="${sessionScope.member.id ne null}">
			<div class="heartBtn">
				<img src="image/greyHeart.png">
			</div>
		</c:if>
		<div class="downBtnBox">
			<button class="downBtn" type="button" onmouseover="viewPrice(${photo.price})">다운로드</button>
		</div>
	</div>
</div>
<div class="main reply">
	<table class="replyInPutTable">
		<tr>
			<td class="profileTd"><img class="replyProfile" src="upload/${sessionScope.member.profile}"></td>
			<td class="nicTd"><label class="replyNic">${sessionScope.member.nicName}</label></td>
			<td class="inputTd"><input type="text" maxlength="100" placeholder="댓글 입력.."></td>
			<td class="buttonTd"><button class="replyBtn">댓글 쓰기</button></td>
		<tr>
	</table>
	<table class="replyInPutTable">
		<c:forEach var="replyList" items="${replyList}">
		<tr>
			<td class="reProfile"><img class="profileTd" src="upload/${replyList.profile }"></td>
			<td class="nicTd"><label class="replyNic">${replyList.nicName }</label></td>
			<td class="inputTd">${replyList.content }</td>
		</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="footer.jsp"%>

