<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<style>
	.grid {
  display: grid;
  grid-template-rows: 
    repeat(4, 180px);
  grid-template-columns: 
    repeat(3, 1fr);
  grid-gap: 5px;
}

.item:nth-child(1) {
  grid-row: 1 / 4;
}

.item:nth-child(2) {
  grid-column: 2 / 4;
  grid-row: 1 / 3;
}

.item:nth-child(3) {
  grid-column: 3 / 4;
  grid-row: 3 / 5;
}

.item:nth-child(4) {
  grid-column: 2 / 3;
  grid-row: 3 / 4;
}

.item:nth-child(5) {
  grid-column: 1 / 3;
  grid-row: 4 / 5;
}

/* styling code */

.grid {
  margin:20px auto;
  max-width:1000px;
}

.grid > .item {
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
</style>

<%@ include file="neck.jsp"%>
<div class="grid">
  <div class="item" style="background-image: url(https://images.unsplash.com/photo-1439209306665-700c9bca794c?dpr=1&auto=format&fit=crop&w=1500&h=1000&q=80&cs=tinysrgb&crop=)"></div>
  
  <div class="item" style="background-image: url(https://images.unsplash.com/photo-1466853817435-05b43fe45b39?dpr=1&auto=compress,format&fit=crop&w=1199&h=871&q=80&cs=tinysrgb&crop=)"></div>
  
  <div class="item" style="background-image: url(https://images.unsplash.com/photo-1488572384981-eac03dfeb6b9?dpr=1&auto=compress,format&fit=crop&w=1199&h=799&q=80&cs=tinysrgb&crop=)"></div>
  
  <div class="item" style="background-image: url(https://images.unsplash.com/photo-1470091688026-38b51162c8df?dpr=1&auto=compress,format&fit=crop&w=1199&h=750&q=80&cs=tinysrgb&crop=)"></div>
  
  <div class="item" style="background-image: url(https://images.unsplash.com/photo-1475139450941-3b6464b2dde3?dpr=1&auto=compress,format&fit=crop&w=1199&h=673&q=80&cs=tinysrgb&crop=)"></div>
</div>

<%@ include file="footer.jsp"%>

