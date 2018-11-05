
//下面ajax↓↓↓↓↓↓↓↓↓↓
/*删除*/
function jiaoseDelete(id){
	//alert("ajax在执行");
	$(document).ready(function(){
		var msg = "您真的确定要删除吗？";
		if (confirm(msg)==true)
		{
			var url="jiaoseguanli_servlet";
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
function jiaoseupdate(){
	 // alert("ajax在执行");
     		var url="jiaoseguanli_servlet";
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
  function jiaoseadd(){
	  //alert("ajax在执行");
 			 var url="jiaoseguanli_servlet";
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
//---------------------------------------------------------------
//网页js
 
	  	function editer(editer,jid,supplier,goods)/*编辑按钮方法*/
	  	{
	  		$("#windows").show();
	  		$("#fugai").show();
	  		$("#value").val("修改");
	  			$("html").css('overflow','hidden');
	  		$("#jid").val(jid);
	  		$("#supplier").val(supplier);
	  		$("#goods").val(goods);
	  	}	
	  	
	  function liujian()
	  	{		
	  		var a=$("#form input[type='text']");
	  	
	  		for(var i=1;i<a.length;i++)
	  		{
	  			if(a[i].value=="")
	  			{
	  				alert("请不要留空");
	  				return false;
	  			}		
	  			else
	  			{
	  				//不为空则执行添加	
	  				if($("#value").val()=="添加"	)
	  					{	
	  						$(function(){//("#value").click由于外面有点击就事件liujian在加一个多余
	  						onclick=jiaoseadd();
	  						});
	  					}
	  				else if($("#value").val()=="修改")
	  				{
	  					$(function(){
	  						onclick=jiaoseupdate();
	  						});
	  				}
	  				return true;
	  			}
	  		}
	  }
	  
	  $(document).ready(function(){
		  $("#add").click(function(){//添加按钮 
		  		$("#windows").show();//显示覆盖层和窗口
		  		$("#fugai").show();
		  		$("html").css('overflow','hidden');//弹窗后的背景不溢出
		  		$("#value").val("添加");
		  		$("#form input[type='text']").val("");	
		  	});
		  	});
		  $(document).ready(function(){
		  $("#close").click(function(){//关闭覆盖层和窗口
		  		$("#windows").hide();
		  		$("#fugai").hide();
		  		$("html").css('overflow','auto');
		  	});
		  });
		  	$(document).ready(function(){	//当页面数据为空时
		  			if($(".tr td").text()==""||$(".tr td").text()==null)
		  				{
		  					$(".td").show();	
		  					$(".td").css({"color":"red"});
		  					$(".td").text("----当前搜索数据为空或者还没有数据哦----");	
		  				}
		  				else
		  				{
		  					$(".td").hide();	
		  				}
		  		}); 
	  