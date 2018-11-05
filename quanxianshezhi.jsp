<%@ page language="java" import="java.util.*,entity.quanxianbiao" pageEncoding="utf-8"%>
<%@page import="entity.quanxianliebiao" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'quanxianshezhi.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

  </head>
  <style>

#qxb{
width:1000px;
min-width:700px;
height:auto;
 position:absolute;
  top:200px;
  left:300px;
  margin:0 auto;
 margin-left:15%;
}
 #qxk1,#qxk2,#qxk3,#qxk4,#qxk5{/*选项卡div*/
  float:left;
 }
 #qxk6{
 display:none;
 }
 .xxkborder{/*选项卡*/
 background:transparent;
 width:150px;
 height:40px;
 line-height:40px;
 font-size:20px;
 text-align:center;
border:#999 1px solid;
cursor:pointer;
 }
  .xxkborder:hover{/*选项卡*/
 background:#999;
 }
 #qxsz1,#qxsz2,#qxsz3,#qxsz4,#qxsz5{
position:absolute;
left:0PX;
 }
 table{
  border-spacing:0px;
    margin-top:10px;
     border-color:#999;
 }
 td{
 width:148px;
 height:30px;
 border:1px solid #999;
 border-top:none;
 text-align:CENTER;
 }

  </style>
  <body>

  	
	<div id="qxb">
				<%ArrayList<quanxianbiao> list=(ArrayList<quanxianbiao>)request.getAttribute("qxblist");
					int i=1;int j=1;int k=1;
					for(quanxianbiao qxb:list){%>
					<div id="qxk<%=i++%>"><!--控制div-->
					<% ArrayList<quanxianliebiao> qxlb=qxb.getQxlblist();%>
						<div class="xxkborder" onclick="xxk('qxsz<%=j++%>')"><!-- 选项卡 -->		
						<%=qxb.getXtmingcheng()%>	
						</div>
					<div id="bg"><!-- 包裹下面div,在jquery好获取id -->
						<div id="qxsz<%=k++%>"><!-- 权限设置 -->
						
						<table border="1">
						<tr>
						<td>序号</td>
						<td>功能</td>
						<td>浏览</td>
						</tr>
					<%
						int l=1;
					for(quanxianliebiao lb:qxlb){%>
					
					<%if(lb.getShangjiid()!=0){ %>
					<tr>
					<td><%=l++ %></td>
					<td style="font-size:20px;"><%=lb.getXtmingcheng() %></td><!-- 获取checxbox为true的值 -->
					<td style="margin-left:15px;"><input type="checkbox" name="checkbox" value="<%=lb.getJsqxid() %>" <%if(lb.getLiulan()==1){ %>checked="true"<%} %>></td>
					</tr>
						<%}
						}//for循环结束
						%>
						</table>
						</div>
					</div>	
				</div>
					<%}%>				
</div>
  </body>

  	<script>
$(document).ready(function(){
var id= $("#bg div").attr("id"); 
var firstid="#"+id;
$("#bg div").each(function(){
var id= $(this).attr("id");
	var xxk="#"+id;
   $(xxk).hide();
   $(firstid).show();
});
});
function xxk(obj){
	var obj="#"+obj;
  $("#bg div").each(function(){
   var id= $(this).attr("id");
	var xxk="#"+id;
   $(xxk).hide();
}); 
$(obj).show();
}
</script>
</html>
