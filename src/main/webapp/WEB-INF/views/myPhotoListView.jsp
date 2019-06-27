<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link type="text/css" rel="stylesheet" href="css/myPhotoList.css">

<%@ include file="neck.jsp"%>
<%@ include file="myPageSideBar.jsp"%>

<div id="main">
	<div class="mainCategory">
		<c:forEach var="myPhotoList" items="${myPhotoList}">
			<div class="category" onclick="location.href='detailPhotoView.do?photoId=${myPhotoList.photoId}'">
				<img src="upload/${myPhotoList.photoPath}">
				<div class="overlayCategory"><div class="textCategory">${myPhotoList.hashTag }</div></div>
				<div class="textCategory">${myPhotoList.hashTag }</div>
			</div>
		</c:forEach>
	</div>
</div>

<%@ include file="footer.jsp"%>

