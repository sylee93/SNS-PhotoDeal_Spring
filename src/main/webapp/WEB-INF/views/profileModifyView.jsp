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
	<a href="#">프로필 수정</a> 
	<a onclick="">찜 목록</a>
	<a onclick="">팔로우</a>
	<a onclick="">포인트 충전</a>
</div>
<div id="main">
	<form action="myPageView.do" name="frm" enctype="multipart/form-data" method="POST">
	<input type="hidden" name="myPageStatus" value="profileModi">
		<div class="signUpBox">
			<h1>프로필 사진 수정</h1>
			<hr>
			<br>
			<div id="preview" class="sugnUpProfile">
				<img src="image/user.png">
			</div>
			<br> <label>프로필</label><br> <input class="input"
				id="profilePath" name="profilePath" type="file"
				value="${sessionScope.member.profile }" onchange="fileCheck()"
				accept='image/jpeg,image/gif,image/png'><br>
			<br> <input type="hidden" name="path"
				value="${pageContext.request.contextPath}/resources/image/">

			<input class="regiBtn" type="submit" value="수정완료">
		</div>
	</form>
<script type="text/javascript">
var rmImg = document.getElementById('preview');
var upload = document.querySelector('#profilePath');
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
})()
upload.addEventListener('change',function (e) {
    var get_file = e.target.files;
    if(get_file){
        reader.readAsDataURL(get_file[0]);
    }
    preview.appendChild(image);
})
function fileCheck(){
	var val = document.getElementById("profilePath").value;
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
		baseImg.setAttribute("src", "image/user.png");
		document.getElementById("preview").appendChild(baseImg);
	}
	if(fileType=='JPG'||fileType=='GIF'||fileType=='PNG'||fileType=='JPEG'||fileType=='BMP' || fileType==null){
		return true;
	} else {
		alert("이미지 파일(JPG, GIF, PNG, JPEG, BMP)만 등록가능 합니다.")
		frm.profilePath.value = "";
		return false;
	}
}
</script>
</div>
<%@ include file="footer.jsp"%>

