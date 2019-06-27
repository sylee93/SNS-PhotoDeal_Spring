<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link type="text/css" rel="stylesheet" href="css/myPhotoList.css">

<%@ include file="neck.jsp"%>
<%@ include file="myPageSideBar.jsp"%>

<div id="main">
	<div class="mainCategory">
		<c:forEach var="myAttentionList" items="${myAttentionList}">
			<div class="category" onclick="location.href='detailPhotoView.do?photoId=${myAttentionList.photoId}'">
				<img src="upload/${myAttentionList.photoPath}">
				<div class="overlayCategory"><div class="textCategory">${myAttentionList.hashTag }</div></div>
				<div class="textCategory">${myAttentionList.hashTag }</div>
			</div>
		</c:forEach>
	</div>
</div>

<%@ include file="footer.jsp"%>

