<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<style>
.mainCategory {
	margin-left: 5%;
}

.category {
	position: relative;
	width: 30%;
	height: 300px;
	display: inline-block;
	overflow: hidden;
}

.category img {
	width: 100%;
	height: auto;
	opacity: 2;
	display: block;
	min-height: 300px;
}

.overlayCategory {
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	height: 100%;
	width: 100%;
	background-color: grey;
	opacity: 0.3;
	bottom: 0;
	left: 0;
	right: 0;
	cursor: pointer;
}
.overlayCategory:hover {
	background-color: #f47f7f;
	opacity: 0.9;
	z-index: 1;
}

.textCategory {
	cursor: pointer;
	color: white;
	font-size: 3rem;
	position: absolute;
	top: 50%;
	left: 50%;
	-webkit-transform: translate(-50%, -50%);
	-ms-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
	text-align: center;
}
</style>

<%@ include file="neck.jsp"%>
<hr>
<div class="mainCategory">
	<div class="category">
		<img src="image/test14.jpg">
		<div class="overlayCategory"><div class="textCategory">BLUE</div></div>
		<div class="textCategory">BLUE</div>

	</div>
	<div class="category">
		<img src="image/test15.jpg">
		<div class="overlayCategory"><div class="textCategory">노을</div></div>
		<div class="textCategory">노을</div>

	</div>
	<div class="category">
		<img src="image/test16.jpg">
		<div class="overlayCategory"><div class="textCategory">SKY</div></div>
		<div class="textCategory">SKY</div>

	</div>
	<div class="category">
		<img src="image/test17.jpg">
		<div class="overlayCategory"><div class="textCategory">BEAUTIFUL</div></div>
		<div class="textCategory">BEAUTIFUL</div>

	</div>
	<div class="category">
		<img src="image/test18.jpg">
		<div class="overlayCategory"><div class="textCategory">FLOWER</div></div>
		<div class="textCategory">FLOWER</div>
	</div>
	<div class="category">
		<img src="image/test19.jpg">
		<div class="overlayCategory"><div class="textCategory">VIOLET</div></div>
		<div class="textCategory">VIOLET</div>
	</div>
	<div class="category">
		<img src="image/test20.jpg">
		<div class="overlayCategory"><div class="textCategory">풍경</div></div>
		<div class="textCategory">풍경</div>
	</div>
</div>

<%@ include file="footer.jsp"%>

