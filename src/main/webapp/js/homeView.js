window.onload = function() {
	if (document.getElementById("btnStatus").value == 0) {
		document.getElementById("lateBtn").className = "sortbtn active";
		document.getElementById("likeBtn").className = "sortbtn";
		document.getElementById("downBtn").className = "sortbtn";
	} else if (document.getElementById("btnStatus").value == 1) {
		document.getElementById("lateBtn").className = "sortbtn";
		document.getElementById("likeBtn").className = "sortbtn active";
		document.getElementById("downBtn").className = "sortbtn";
	} else {
		document.getElementById("lateBtn").className = "sortbtn";
		document.getElementById("likeBtn").className = "sortbtn";
		document.getElementById("downBtn").className = "sortbtn active";
	}
}