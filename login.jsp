<%@ page language="java" import="java.util.*,dao.Logindao,entity.jiaosequanxian" pageEncoding="utf-8"%>
 
<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>
        <meta charset="utf-8">
        <title>登录界面</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS 
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="css/reset.css">
                <link rel="stylesheet" href="css/supersized.css">
        -->
        
        <link rel="stylesheet" href="css/loginstyle.css">
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="js/ajax.js"></script>
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js" ></script>
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>
    <body>

        <div class="page-container">
            <h1>后台登录界面</h1>
            <form id="loginform" action="" method="post" >
                <input type="text" name="username" id="username" class="username" placeholder="用户名" autocomplete="off" onblur="User_name()">
                <div id="mydiv" style="color:red;"></div>
                <input type="password" name="password" id="password" class="password"  placeholder="密码">
                <input type="button"value="登录" onclick="liujian()">
               <input type="button"  disabled="disabled" style="background:#ccc;" value="注册"onclick="location.href='register.jsp'">
            </form>
          </div>

       
	<script>

	function liujian(){
		var username=document.getElementById("username").value;
		var userpwd=document.getElementById("password").value;
		if(username==""){			
			alert("用户名称必须填写！");
			document.getElementById("username").focus();
			return false;			
		}		
		if(userpwd==""){
			alert("用户密码必须填写！");
			document.getElementById("password").focus();
			return false;
		}
		login();
		
		return true;
	
		}
		</script>
    </body>
	 <%--
	 if(res.equals("ok")!=true&&request.getParameter("password")!=null){
	  if(res=="")
	  {
	  return;
	  }
	  else{
	    out.println("<script language='JavaScript'> alert('"+res+"');</script>");
	    }
	    
	    }
	     --%>
</html>

