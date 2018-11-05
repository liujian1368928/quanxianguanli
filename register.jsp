<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
	<%
		String account_number=request.getParameter("txtusername");//获取txtusername参数
		String password=request.getParameter("txtuserpwd");
		String alert="";
		//register add=new register();
		//alert=add.add_data(account_number,password);
	%>
 <!doctype html>
 <html lang="zh-CN">
 <head>
   <meta charset="UTF-8">

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/ajax_register.js"></script>

   </script>
 
   <title>用户注册</title>
 </head>
 <style>  
.bg{    
      
      
        }
  .bg:hover{

      }
 </style>
 <link type="text/css" rel="stylesheet" href="css/register.css" />
 <script src="js/ajax_"></script>
 <body>
 <div class="container">
 <div class="bg">
 </div>
    <div id="border">
    <form action="" method="post" onsubmit="return checkform()">
					<div id="login_tip">
						<p style="font-size:25px;color:#fff;">用户注册</p>

						<div class="username_input">帐号：<input type="text" class="username" name="txtusername" id="account_number" onblur="register()"></div>
						<div id="mydiv"></div><br>
		
						<div class="username_input">密码：<input type="text" class="pwd" name="txtuserpwd" id="password"></div><br>
					</div>
					<div id="btn_area">
						<input type="submit" name="submit" id="sub_btn" value="注&nbsp;&nbsp;册">
						<input type="reset" name="reset" id="reset_btn"  value="重&nbsp;&nbsp;置">
					</div>
					
					<div id="text">					
					</div>
				</form>
			</div>
		</div>
   <script language="javascript">
	function checkform(){		
		var username=document.getElementById("account_number").value;
		if(username==""){			
			alert("用户名称必须填写！");
			document.getElementById("account_number").focus();
			return false;			
		}		
		var userpwd=document.getElementById("password").value;
		if(userpwd==""){
			alert("用户密码必须填写！");
			document.getElementById("password").focus();
			return false;
		}
		return true;
	}
	</script>
	<%
if(alert.equals("注册成功")==true)
	{
	String txt="2秒后跳转到登录页";
	out.println("<script>var txt=document.getElementById('text'); txt.innerHTML='"+alert+txt+"';</script>");
	session.setAttribute("username", account_number);
	response.setHeader("refresh", "2;URL=login.jsp");
		//response.sendRedirect("login.jsp");
	}
		if(alert.equals("帐号已被注册")==true&&request.getParameter("txtusername")!=null&&request.getParameter("txtuserpwd")!=null)
	{
	String txt=",请重新输入";
	out.println("<script>var txt=document.getElementById('text'); txt.innerHTML='"+alert+txt+"';</script>");

	}
	 %>
 </body>
 </html>
  