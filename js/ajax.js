function savecheckbox(){//保存权限
					var url="savecheck_servlet";		
					var data=$("#qxlb").serialize();		
					$.ajax({
						url:url,
						data:data,
						type:"post",
						dataType:"text",
						success: function(result) {				
						alert(result);		
						tijiao();
						//刷新左边导航栏
						//$('#iframe').attr('src', $('#iframe').attr('src'));
						//$("#iframe").window.location.reload();
							//$("#divquanxianliebiao2").text(result);			
						},
						error : function() { //请求失败后要执行的代码
						
						}				
					});
	
	}
function getqxlb(){//获取权限列表
				var jsid= $("#selectjiaose").val();
				if(jsid=="0")
				{
					$("#divquanxianliebiao").html(null);		
				}else{
				var url="quanxianbiao_servlet";		
				var data=$("#selectjiaose").serialize();		
				$.ajax({
					url:url,
					data:data,
					type:"post",
					dataType:"text",
					success: function(result) {				
						$("#divquanxianliebiao").html(result);		
						//$("#divquanxianliebiao2").text(result);			
					},
					error : function() { //请求失败后要执行的代码
					
					}				
				});
			
			}
		}
	


function tijiao(){//刷新左边导航栏
//用onload触发执行一次
	//alert("tijiao在运行");
			var url="menu_servlet";			
				$.ajax({
					url:url,
					data:null,
					type:"post",
					dataType:"text",
					success: function(result) {				
						$("#main").html(result);			
					},
					error : function() { //请求失败后要执行的代码
					}				
				});
	}

/*搜索*/
function Search(){
     		var url="check_servlet";
			var data=$("#search").serialize();	//+"&action=search"
			alert(data);
			$.ajax({
				url:url,
				data:data,
				type:"post",
				dataType:"text",
				success: function(result) {	
					var info=eval("("+result+")");
					alert(info);
							alert(result);
						
							
				//$("#text").text(result);
					
					//location.reload();
				},
				error : function() { 
				}				
			});
    
}

/*注册页面*/
function register(){
  	var url="ajaxregister.jsp";//链接到getuserlistdata.jsp
	var data=$("#account_number").serialize();//将获取的表单内容序列化成字符串。	
	$.ajax({
	  	url : url,                                 //要提交的URL路径
		type : "post",                           //发送请求的方式
		data : data,                            //要发送到服务器的数据
		dataType : "text",                 //指定传输的数据格式
		success : function(q) {//请求成功后要执行的代码  function(q)返回getuserlistdata.jsp里的代码
			//alert(q);
			$("#mydiv").html(q);//在browseuser.jsp
		},
		error : function() {  //请求失败后要执行的代码
		}
	});
}
/*登录页面用户名是否存在验证*/
function User_name(){
	//alert("ajax在运行");
  	var url="login_servlet";//链接到ajaxlogin.jsp
	var data=$("#username").serialize()+"&action=yanzheng";//将获取的表单内容序列化成字符串
	$.ajax({
	  	url : url,                                 //要提交的URL路径
		type : "post",                           //发送请求的方式
		data : data,                            //要发送到服务器的数据
		dataType : "text",                 //指定传输的数据格式
		success :function(q) {//请求成功后要执行的代码  function(q)返回getuserlistdata.jsp里的代码
			$("#mydiv").html(q);//在browseuser.jsp
		},
		error : function() {  //请求失败后要执行的代码
			
		}
	});
}
/*登录*/
function login(){
	
	var url="login_servlet";
	var data=$("#loginform").serialize()+"&action=login";
$.ajax({
	url:url,
	type:"post",
	data:data,
	dataType:"text",
	success: function(result) {		
	if(result!="0"){
		window.location.href="welcome.jsp";
	}else{
		alert("密码错误");
	}
	},
	error : function() { //请求失败后要执行的代码
		alert("ajax错误");
	}				
});  
}
//下面ajax↓↓↓↓↓↓↓↓↓↓
/*删除*/
function Delete(id){
	$(document).ready(function(){
		var msg = "您真的确定要删除吗？";
		if (confirm(msg)==true)
		{
			var url="add_delete_change_cheak";
			var data={"id":id,"action":"Delete"};
			$.ajax({
				url:url,
				data:data,
				type:"post",
				dataType:"text",
				success: function(result) {
					location.reload();
					alert(result);
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
function update(){
     		var url="add_delete_change_cheak";
			var data=$("#form").serialize()+"&action=update";
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
/*添加数据*/
  function add(){
 			 var url="add_delete_change_cheak";
			var data=$("#form").serialize()+"&action=addnew";
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
