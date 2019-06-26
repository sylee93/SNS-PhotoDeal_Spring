<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/detailPhoto.css">
<script type="text/javascript" src="js/detailPhoto.js"></script>
<%@ include file="neck.jsp"%>
<%
	String context = request.getContextPath();
    System.out.println("context->"+context);
%>
<div class="main">
<input type="hidden" id="photoIdParam" value="${photo.photoId }">
	<div class="modiBtnBox">
		<c:if test="${sessionScope.member.id eq creator.id}">
			<button type="button" class="modiBtn" onclick="location.href='modifyPhotoView.do?photoId=${photo.photoId}'">수정</button>
			<button type="button" class="modiBtn" onclick="location.href='deletePhoto.do?photoId=${photo.photoId}'">삭제</button>
		</c:if>
	</div>
	<div class="photoInfo">
		<span class="creator"> <img src="upload/${creator.profile}" >
			${creator.nicName } </span>
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
		<img src="upload/${photo.photoPath }">
	</div>
	<div class="comment">
		${photo.pcomment }
	</div>
	<div class="photoBtn" >
		<c:if test="${sessionScope.member.id ne null}">
			<c:if test="${attentionlist ne null }">
				<div class="heartBtn" onclick="clickHeart()">
					<img id="heartCheck" src="image/redHeart.png">
				</div>
			</c:if>
			<c:if test="${attentionlist eq null }">
				<div class="heartBtn" onclick="clickHeart()">
					<img id="heartCheck" src="image/greyHeart.png">
				</div>
			</c:if>
		</c:if>
		<div class="downBtnBox">
			<button class="downBtn" type="button" onmouseover="viewPrice(${photo.price})">다운로드</button>
		</div>
	</div>
</div>
<div class="main reply">
	<table class="replyInPutTable">
		<tr>
			<c:if test="${sessionScope.member.id ne null }">
				<td class="profileTd"><img class="replyProfile" src="upload/${sessionScope.member.profile}"></td>
			</c:if>
			<c:if test="${sessionScope.member.id eq null }">
				<td class="noLoginProfileTd" colspan="2"><label class="nologin">로그인을 해주세요</label></td>
			</c:if>
			<c:if test="${sessionScope.member.id eq null }">
				
			</c:if>
			<c:if test="${sessionScope.member.id ne null }">
				<td class="nicTd"><label class="replyNic">${sessionScope.member.nicName}</label></td>
			</c:if>
			<td class="inputTd"><input id="writeRf" type="text" maxlength="100" placeholder="댓글 입력.."></td>
			<td class="buttonTd"><button class="replyBtn" onclick="writeReply()">댓글 쓰기</button></td>
		<tr>
	</table>
	<div id="replyAjax"></div>
	<table class="replyInPutTable">
		<c:forEach var="replyList" items="${replyList}">
		<tr class="checkReply" id="${replyList.replyId}">
			<td class="profileTd"><img class="replyProfile" src="upload/${replyList.profile }"></td>
			<td class="nicTd"><label class="replyNic">${replyList.nicName }</label></td>
			<td class="replyContent" id="input${replyList.replyId}">${replyList.content } 
				<c:if test="${sessionScope.member.id eq replyList.creator }">
					<button class="updateBtn" onclick="updateReply(${replyList.replyId })">Update</button>
					<button class="deleteBtn" onclick="deleteReply(${replyList.replyId })">Delete</button>
				</c:if>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>
<script type="text/javascript">
function writeReply(){
	$.ajax({
		url:"<%=context%>/reply/writeReply.do",
		type:"POST",
		data : {writeRf : $('#writeRf').val(), photoId : $("#photoIdParam").val() },
		dataType:'json',
		success: function(data){
			var str = '<table class = "replyInPutTable checkReply" id="' + data.replyId + '"><tr><td class="profileTd">';
			str = str + '<img class="replyProfile" src="upload/' + data.profile + '">'
			str = str + '</td><td class="nicTd"><label class="replyNic">' + data.nicName +'</label></td>';
			str = str + '<td class = "inputTd">'+ data.content + '<button class = "updateBtn" onclick="reFresh()">Refresh</td></tr></table>'
			$("#replyAjax").prepend(str);
			alert("댓글입력이 완료되었습니다.");
		}
	})
}
function updateReply(rId) {
	$.ajax({
		url:"<%=context%>/reply/updateReply.do",
		type:"POST",
		data : {replyId : rId },
		dataType:'json',
		success: function(data){
			var updateId = "input"+data.replyId
			var str = '<input class="inputUpdate" type="text" maxlength="100" value="'+data.content+'">'
			str = str + '<button class="replyBtn" onclick="updateContent('+data.replyId+')">수정</button>'
			document.getElementById(updateId).innerHTML = str ;
		}
	})
}
function deleteReply(rId) {
	$.ajax({
		url:"<%=context%>/reply/deleteReply.do",
		type:"POST",
		data : {replyId : rId },
		dataType:'json',
		success: function(data){
			document.getElementById(data).remove();
			alert("댓글이 삭제 되었습니다.");
		}
	})
}
function reFresh(){
	location.reload();
}
function updateContent(rId){
	var photoId = $("#photoIdParam").val();
	var content = $(".inputUpdate").val();
	location.href="updateReply?replyId="+rId+"&content="+content+"&photoId="+photoId;
}
function clickHeart(){
	var photoId = $("#photoIdParam").val();
	var status = $("#heartCheck").attr("src");
	var checkStr = "image/greyHeart.png";
	console.log("status"+status);
	console.log("checkStr"+checkStr);
	if (status == checkStr){
		$.ajax({
			url:"<%=context%>/photo/clickHeart.do",
			type:"POST",
			data : {photoId : photoId, check : "grey" },
			dataType:'text',
			success: function(data){
				$("#heartCheck").attr("src",data);
			}
		})	
	}
	else {
		$.ajax({
			url:"<%=context%>/photo/clickHeart.do",
			type:"POST",
			data : {photoId : photoId, check : "red"},
			dataType:'text',
			success: function(data){
				$("#heartCheck").attr("src",data);
			}
		})
	}
}
</script>
<%@ include file="footer.jsp"%>

