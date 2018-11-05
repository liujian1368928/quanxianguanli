<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String zhi=(String)session.getAttribute("username");
Object zhiwei=session.getAttribute("zhiwei");

	// session.invalidate();
	 //session.setMaxInactiveInterval(1);
	// out.println(request.getSession(false)==null);
 /*if(request.getSession(false)==null)
 {
 out.println("1");
 }
 else{
 out.println("2");
 }*/

		//int a=session.getMaxInactiveInterval();
//response.sendRedirect("login.jsp");

 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="js/jquery-1.8.3.js"></script>
  </head>
  <body>
		<div id="head_top">
			 <div class="logo">
			        后台管理系统          
			 </div>
		 	<!--  <div class="search">
			 <input type="text" />
			 <input type="button" value="搜索">
		 	</div>-->
			 <div class="user">
			   当前用户为:
			   <span class="information" style="color:red;"><%=zhi %>
				   <div class="user_information">
				你的职位为<span class="information" style="color:red;font-size:22px;"><%=zhiwei %></span><p>欢迎来到后台管理系统</p>
				   </div>
			    </span>
			    <span>
			    <a href="logout_servlet">退出</a>
			    </span>
			 </div>
		</div>
  </body>
    <script>
$(function(){
$(".user_information").hide();
});
$(".information").mouseover(function(){//头部用户信息
	  $(".user_information").show();
	   
	   });
$(".information").mouseout(function(){//头部用户信息
	  $(".user_information").hide();
	   
	   });
</script>
</html>
