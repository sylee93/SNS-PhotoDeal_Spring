function idLengthCheck(){
	$.ajax({
		url:"<%=context%>/user/idLengthCheck.do",
		type:"POST",
		data : {id : $('#id').val()},
		dataType:'text',
		success: function(checkMsg){
			$('#msgIdLengthCheck').html(checkMsg);
		}
	})
}
function idDuplicate(){
	$.ajax({
		url:"<%=context%>/user/idDuplicate.do",
		type:"POST",
		data : {id : $('#id').val()},
		dataType:'text',
		success: function(idDupleMsg){
			$('#msgIdDuplCheck').html(idDupleMsg);
		}
	})
}
function nicDuplicate(){
	$.ajax({
		url:"<%=context%>/user/nicDuplicate.do",
		type:"POST",
		data : {nicName : $('#nicName').val()},
		dataType:'text',
		success: function(nicDupleMsg){
			$('#msgNicDuplCheck').html(nicDupleMsg);
		}
	})
}