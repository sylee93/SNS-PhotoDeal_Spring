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
<c:if test="${modifyPhotoResult != '0'}">
	<script type="text/javascript">
		alert("수정이 완료 되었습니다.");  
		location.href="homeView.do";
	</script>
</c:if> 
<c:if test="${modifyPhotoResult == '0'}">
	<script type="text/javascript">
		alert("수정을 실패하였습니다.");  
		location.href="writeView.do";
	</script>
</c:if> 
</body>
</html>