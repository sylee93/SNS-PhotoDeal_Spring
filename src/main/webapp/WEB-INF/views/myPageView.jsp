<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link type="text/css" rel="stylesheet" href="css/myPage.css">

<%@ include file="neck.jsp"%>
<%
	String context = request.getContextPath();
    System.out.println("context->"+context);
%>

<hr>

<div class="sidenav">
	<a onclick="">내 정보</a> 
	<a onclick="">내가 쓴 글</a> 
	<a onclick="userModify()">정보 수정</a>
	<a onclick="">찜 목록</a> 
	<a onclick="">팔로우</a>
	<a onclick="">포인트 충전</a>
</div>
<div class="main">

</div>

<script>
function userModify(){
	$.ajax({
		url:"/WEB-INF/views/signModify.jsp",
		type:"POST",
		data : $('form').serialize(),
		dataType:'html',
		success: function(nicCheckMsg){
			$('#msgNicCheck').html(nicCheckMsg);
		}
	})
}
</script>
<%@ include file="footer.jsp"%>

