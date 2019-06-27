<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/signUp.css">
<link type="text/css" rel="stylesheet" href="css/myInfo.css">

<%@ include file="neck.jsp"%>
<%@ include file="myPageSideBar.jsp"%>
<div id="main">
	<table class="mainTable">
		<tr>
			<td class="profileImg" rowspan="7"><img src="upload/${sessionScope.member.profile }"></td>
			<td><label class="myName">아이디 :  </label><label class="myName"> ${sessionScope.member.id }</label></td>
		</tr>
		<tr>
			<td><label class="myName">닉네임 :  </label><label class="myName"> ${sessionScope.member.nicName }</label></td>
		</tr>
		<tr>
			<td><label class="myName">E-Mail :  </label><label class="myName"> ${sessionScope.member.email }</label></td>
		</tr>
		<tr>
			<td><label class="myName">팔로잉 수 :  </label><label class="myName"> ${following }</label></td>
		</tr>
		<tr>
			<td><label class="myName">팔로워 수 :  </label><label class="myName"> ${follower }</label></td>
		</tr>
		<tr>
			<td><label class="myName">가입일 :  </label><label class="myName"> ${sessionScope.member.createDate }</label></td>
		</tr>
		<tr>
			<td><label class="myName">보유 포인트 :  </label><label class="myName"> ${sessionScope.member.point }</label></td>
		</tr>
	</table>
</div>

<%@ include file="footer.jsp"%>

