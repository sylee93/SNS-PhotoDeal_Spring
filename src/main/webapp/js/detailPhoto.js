function viewPrice(price){
	var price = price + "포인트";
	if (price == "0포인트"){
		price = "무료";
	}
	var val = $(".downBtn").html(price);	
	$('.downBtn').mouseleave(function(){
		$(".downBtn").html("다운로드");
	});
}