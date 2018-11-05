<%@ page language="java" import="java.util.*,entity.jiaosequanxian" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'quanxian.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/ajax.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <style>
#container {	
	width:100%;
	height:auto;
}
#container #index{
width:auto;
 height:auto;
  }
 #container{
  width:auto;
  min-width:1300px;
  height:auto;
  margin:0 auto;
  }
  #big_box{
  text-align:center;
  }
 select{
 border:1px solid #999;
width:100px;
height:30px;
 }
 input[type='button']{
 	width:50px;
 	height:30px;
 	background:transparent;
 	 border:1px solid #999;
 }
  input[type='button']:hover{
 	background:#ccc;
 
 }
   </style>

<script>
</script>
  <body>
  
 <div id="container">
	<div id="index">
			<jsp:include page="index2.jsp"></jsp:include>
	 </div><!-- index结束 -->
			<form action="" method="post" id="qxlb">
			  <div id="big_box">
					
					<select onchange="getqxlb()" name="selectjiaose" id="selectjiaose">
						<option value="0">选择</option>
					<%
						ArrayList<jiaosequanxian> list=(ArrayList<jiaosequanxian>)request.getAttribute("jslist");
								for(jiaosequanxian js:list){
					%>
					<option value="<%=js.getJid() %>"><%=js.getJiaosemingcheng() %></option>
						<%} %>
					</select>
					<input type="button" value="保存" onclick="savecheckbox()">
				</div>
  
			 <div id="divquanxianliebiao">
    		</div>
    		</form>
</div>
  	<script>
	
	</script>
  </body>
  <script language="JAVASCRIPT" src='ajax.js'></script> 
</html>
