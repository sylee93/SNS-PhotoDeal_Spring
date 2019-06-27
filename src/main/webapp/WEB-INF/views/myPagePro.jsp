<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign Up Process View</title>
</head>
<body> 
<c:if test="${resultModify == 'successUpdateModify'}">
	<script type="text/javascript">
		alert("회원정보가 수정되었습니다.");  
		location.href="myInfoView.do";
	</script>
</c:if> 
<c:if test="${resultModify == 'failUpdateModify'}">
	<script type="text/javascript">
		alert("회원정보 수정을 실패하였습니다.");
		location.href="myInfoView.do";
	</script>
</c:if>
<c:if test="${resultProfile == 'failUpdateProfile'}">
	<script type="text/javascript">
		alert("프로필 수정을 실패하였습니다.");  
		location.href="myInfoView.do";
	</script>
</c:if> 
<c:if test="${resultProfile == 'successUpdateProfile'}">
	<script type="text/javascript">
		alert("프로필이 수정되었습니다.");  
		location.href="myInfoView.do";
	</script>
</c:if>
</body>
</html>