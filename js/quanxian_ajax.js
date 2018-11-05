/**/
function tijiao(){
	var url="quanxian";
	var data=$("#form").serialize();//+"&action=update";
	$.ajax({
		url:url,
		data:data,
		type:"post",
		dataType:"text",
		success: function(result) {	
			alert(result);
			location.reload();
		},
		error : function() { //请求失败后要执行的代码
		
		}				
	});
	
}