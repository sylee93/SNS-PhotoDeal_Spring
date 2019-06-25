<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/writeInfoView.css">
<%@ include file="neck.jsp"%>
<hr>
<form action="writeProView.do" name="frm">
<input type="hidden" name="savedName" value="${savedName}">
	<div class="writeInfoBox">
		<h1>사진 정보등록</h1>
		<hr><br>
		<label>사진 가격</label><br>
		<select id="priceStatus" name="priceStatus"onclick="statusCheck(this)">
			<option value="1" selected="selected">무료</option>
			<option value="2" >유료</option>
		</select> 
		<input class="input" id="point" name="point" type="number" value="0" readonly> <label>포인트</label><br><br>		
		
		<label>코멘트</label><br>
		<textarea id="comment" rows="5" maxlength="150" name="comment"></textarea><br><br>
		
		<label>해시태그</label><br>
		<input class="input" onkeydown="" id="hashTag" type="text" placeholder="#HashTag" name="hashTag" 
		onfocus="addHashTag()" onkeypress="addHashTag()" maxlength="180" autocomplete="off"><br><br>
		<input class="regiBtn" type="submit"  value="등록완료">
	</div>
</form>
<script>
function statusCheck(status){
	var stat = status.selectedIndex
	console.log(stat);
	if(stat == "1") {
		document.getElementById("point").readOnly = "0";
		$("#point").css('background-color','#fff0f0');
	} else if(stat == "0"){
		document.getElementById("point").readOnly = "true";
		document.getElementById("point").value = "";
		$("#point").css('background-color','#d5d5d5');
	}
}

$("#hashTag").bind("keyup",function(){
    re = /[~!@\$%^&*\()\-=+_']/gi; 
    var temp = $("#hashTag").val();
    $("#hashTag").val(temp.replace(" ","#").replace("##","#").replace(re,"")); 
});

function addHashTag(){
	if($("#hashTag").val() == ""){
		$("#hashTag").val("#");
	}
}

</script>
<%@ include file="footer.jsp"%>

