<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link type="text/css" rel="stylesheet" href="css/myPage.css">
<script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/signUp.css">

<%@ include file="neck.jsp"%>


<hr>

<div class="sidenav">
	<a onclick="">내 정보</a> 
	<a onclick="">내가 쓴 글</a>
	<a href="userModifyView.do">정보 수정</a>
	<a href="profileModifyView.do">프로필 수정</a>
	<a onclick="">찜 목록</a> 
	<a onclick="">팔로우</a>
	<a onclick="">포인트 충전</a>
	<a href="leaveProc.do">회원 탈퇴</a> <!-- 나중에!! -->
</div>
<div id="main">
</div>
<c:if test="${resultModify == 'successUpdateModify'}">
	<script type="text/javascript">
		alert("회원정보가 수정되었습니다.");  
	</script>
</c:if> 
<c:if test="${resultModify == 'failUpdateModify'}">
	<script type="text/javascript">
		alert("회원정보 수정을 실패하였습니다.");  
	</script>
</c:if>
<c:if test="${resultProfile == 'failUpdateProfile'}">
	<script type="text/javascript">
		alert("프로필 수정을 실패하였습니다.");  
	</script>
</c:if> 
<c:if test="${resultProfile == 'successUpdateProfile'}">
	<script type="text/javascript">
		alert("프로필이 수정되었습니다.");  
	</script>
</c:if> 
<%@ include file="footer.jsp"%>

