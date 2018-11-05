$(document).ready(function(){
$("#add").click(function(){//添加按钮 
		$("#windows").show();//显示覆盖层和窗口
		$("#fugai").show();
		$("#supplier").val();
		$("#goods").val();
		$("#price").val();
		if($("#value").val()=="添加"	)
		{
			
			$("#value").click(function(){
			onclick=add();
			});
		}
	});
	});
$(document).ready(function(){
$("#close").click(function(){//关闭覆盖层和窗口
		$("#windows").hide();
		$("#fugai").hide();
	});
});
	function editer(editor,supplier,goods,price)
	{
		$("#supplier").val(supplier);
		$("#goods").val(goods);
		$("#price").val(price);
		$(editor).ready(function(){
		$("#windows").show();
		$("#fugai").css('display','block');
		});
		$("#value").val("修改");		//点击编辑时显示为修改
		if($("#value").val()=="修改"	)
		{
			$("#value").click(function(){
			onclick=update();
			});
		}//点击编辑时显示为报价单修改
		
	
	}

/*$(function(){
	$(".list").hide();
});


function liujian(obj){
var id="#"+obj;
var $myli=$(id);
var info=($myli[0].style.display);

if(info=="none"){
$(id).show(200);

}else{
$(id).hide(200);
}
}*/
function add()
	{		
		var a=$("input[type='text']");
	
		for(var i=1;i<a.length;i++)
		{
		if(a[i].value=="")
		{
		alert("请不要留空");
		return false;
		}
		}
		return true;
	} 
