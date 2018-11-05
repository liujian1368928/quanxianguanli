$(document).ready(function(){
$("#add").click(function(){//添加按钮 
		$("#windows").show();//显示覆盖层和窗口
		$("#fugai").show();
		$("html").css('overflow','hidden');//弹窗后的背景不溢出
		$("#value").val("添加");
		$("#form input[type='text']").val("");
	/*	$("#goods").val("");
		$("#price").val("");
		$("#date").val("");
		$("#shuoming").val("");*/
		
	});
	});
$(document).ready(function(){
$("#close").click(function(){//关闭覆盖层和窗口
		$("#windows").hide();
		$("#fugai").hide();
		$("html").css('overflow','auto');
	});
});

	function editer(editer,id,supplier,goods,price,date,shuoming)/*编辑按钮方法*/
	{
		$("#windows").show();
		$("#fugai").show();
		$("#value").val("修改");
		$("html").css('overflow','hidden');
		$("#id").val(id);
		$("#supplier").val(supplier);
		$("#goods").val(goods);
		$("#price").val(price);
		$("#date").val(date);
		$("#shuoming").val(shuoming);

	}	
//上面代码一个窗口多用
	
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
						onclick=add();
						});
					}
				else if($("#value").val()=="修改")
				{
					$(function(){
						onclick=update();
						});
				}
				return true;
			}
		}
		
	
	} 