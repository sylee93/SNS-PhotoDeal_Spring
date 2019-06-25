<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link type="text/css" rel="stylesheet" href="css/writeFormView.css">
<%@ include file="neck.jsp"%>
<hr>
<div class="main">
<form action="writeInfoView.do" enctype="multipart/form-data" method="POST">
<h1>사진 등록</h1>
<hr>
	<div id="preview" class="sugnUpProfile">
		<img src="image/photo.png">
	</div><br>
	<br><label>사진</label><br>
	<input class="input" id="photoPath" name="photoPath" type="file" 
	onchange="fileCheck()" accept='image/jpeg,image/gif,image/png' required="required"><br><br>
	<input class="regiBtn" type="submit" value="등록">
</form>
</div>
<script type="text/javascript">
var rmImg = document.getElementById('preview');
var upload = document.querySelector('#photoPath');
 /* FileReader 객체 생성 */
var reader = new FileReader();
    /* reader 시작시 함수 구현 */
reader.onload = (function () {
    this.image = document.createElement('img');
    var vm = this;  
    return function (e) {
        /* base64 인코딩 된 스트링 데이터 */
        vm.image.src = e.target.result
    }
})();
upload.addEventListener('change',function (e) {
    var get_file = e.target.files;
    if(get_file){
        reader.readAsDataURL(get_file[0]);
    }
    preview.appendChild(image);
});

function fileCheck(){
	var val = document.getElementById("photoPath").value;
	var baseImg = document.createElement("img");
	var point = val.lastIndexOf('.');
	var tempFileType = val.substring(point+1, val.length);
	var fileType = tempFileType.toUpperCase()
	if (val != ""){
		while(rmImg.firstChild) {
	   		rmImg.removeChild(rmImg.firstChild);
		}
	} else {
		while(rmImg.firstChild) {
	   		rmImg.removeChild(rmImg.firstChild);
		}
		baseImg.setAttribute("src", "image/photo.png");
		document.getElementById("preview").appendChild(baseImg);

	}
	if(fileType=='JPG'||fileType=='GIF'||fileType=='PNG'||fileType=='JPEG'||fileType=='BMP' || fileType==null){
		$("#baseImg").val("1");
		return true;
	} else {
		alert("이미지 파일(JPG, GIF, PNG, JPEG, BMP)만 등록가능 합니다.")
		frm.profilePath.value = "";
		return false;
	}
}
</script>
<%@ include file="footer.jsp"%>

