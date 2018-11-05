
//下面ajax↓↓↓↓↓↓↓↓↓↓
/*删除*/
function yonghuDelete(id){
	//alert("ajax在执行");
	$(document).ready(function(){
		var msg = "您真的确定要删除吗？";
		if (confirm(msg)==true)
		{
			var url="yonghuguanli_servlet";
			var data={"id":id,"action":"Delete"};
			$.ajax({
				url:url,
				data:data,
				type:"post",
				dataType:"text",
				success: function(result) {
					location.reload();
					//alert(result);
				},
				error : function() { //请求失败后要执行的代码
				
				}				
			});
		}else
		{
		return false;
		}
	})
}
/*修改更新数据*/
function  yonghuupdate(){
	 // alert("ajax在执行");
     		var url="yonghuguanli_servlet";
			var data=$("#form").serialize()+"&action=update";
			$.ajax({
				url:url,
				data:data,
				type:"post",
				dataType:"text",
				success: function(result) {	
					//alert(result);
					location.reload();
				},
				error : function() { //请求失败后要执行的代码
				
				}				
			});  
}
/*添加数据*/
  function  yonghuadd(){
	  //alert("yonghuajax在执行");
 			 var url="yonghuguanli_servlet";
			var data=$("#form").serialize()+"&action=addnew";
			$.ajax({
				url:url,
				data:data,
				type:"post",
				dataType:"text",
				success: function(result) {
						//alert(result);
					location.reload();	
				},
				error : function() { //请求失败后要执行的代码
				
				}				
			});
  	}
