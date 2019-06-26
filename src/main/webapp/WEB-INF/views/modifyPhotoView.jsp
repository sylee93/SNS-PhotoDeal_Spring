<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/writeInfoView.css">
<%@ include file="neck.jsp"%>
<hr>
<form action="modifyProView.do" name="frm">
<input type="hidden" name="photoId" value="${photo.photoId }">
	<div class="writeInfoBox">
		<h1>사진 정보 수정</h1>
		<hr><br>
		<label>사진 가격</label><br>
		<c:if test="${photo.priceStatus == 1 }">
			<select id="priceStatus" name="priceStatus" onclick="statusCheck(this)">
				<option value="2" >무료</option>
				<option value="1" selected="selected">유료</option>
			</select> 
			<input class="input" id="point" name="price" type="number" value="${photo.price }" max="100000" step="10" > <label>포인트</label><br><br>
		</c:if>		
 		<c:if test="${photo.priceStatus == 2 }">
			<select id="priceStatus" name="priceStatus" onclick="statusCheck(this)">
				<option value="2" selected="selected">무료</option>
				<option value="1" >유료</option>
			</select> 
			<input class="input grey" id="point" name="price" type="number" value="${photo.price }" max="100000" step="10" readonly> <label>포인트</label><br><br>
		</c:if>	
		<label>코멘트</label><br>
		<textarea id="comment" rows="5" maxlength="150" name="comment" >${photo.pcomment }</textarea><br><br>
		
		<label>해시태그</label><br>
		<input class="input" onkeydown="" id="hashTag" type="text" placeholder="#HashTag" name="hashTag" 
		onfocus="addHashTag()" onkeypress="addHashTag()" maxlength="180" autocomplete="off"
		value="${photo.hashTag }"><br><br>
		<input class="regiBtn" type="submit"  value="수정완료">
	</div>
</form>
<script>
function statusCheck(status){
	console.log(status);
	var stat = status.selectedIndex
	console.log(stat);
	if(stat == "1") {
		document.getElementById("point").readOnly = "";
		$("#point").css('background-color','#fff0f0');
	} else{
		document.getElementById("point").readOnly = "true";
		document.getElementById("point").value = "0";
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

