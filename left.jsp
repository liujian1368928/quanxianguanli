<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page  import="entity.menu"%>
<%@ page  import="entity.subMenu"%>
<%--@ include file="LoginControl.jsp" --%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>My JSP 'head.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="js/jquery-1.8.3.js"></script>
	<script src="js/ajax.js"></script>
  </head>
  <body><!-- tijiao() -->
<div id="main">
 <div id="main_left">
	       <% ArrayList<menu> Menu=(ArrayList<menu>)session.getAttribute("menulist");
	      // ArrayList<menu>Menu=(ArrayList<menu>)request.getAttribute("menulist");
	      if(Menu!=null){
	      for(menu menulist:Menu){ %>
	      <%if(menulist.getShangjiid()==0) {%>
	            <div id="bar" onclick="bar('list<%=menulist.getXid() %>')">
	            	  <%=menulist.getXtmingcheng() %>
	            </div>
	            <%} %>		
	            	<div id="list<%=menulist.getXid() %>"  class="list">
						  <%
						ArrayList<subMenu> smlist=menulist.getSubMenu();
							 for(subMenu sm:smlist){
								if(sm.getLiulan()==1) {//判断是否有权限浏览 
						%>	
						<!-- </li> -->
		           			<li onclick="ll(list'<%=menulist.getXid()%>'"><a href="<%=sm.getUrl() %>"><%=sm.getXtmingcheng()%></a></li>
		           			 	<% }
		           			 	}	%>
	          			 </div>		 
	          	<%}} %>
	   </div>
	     <!-- main-left结束 -->  
	
   </div>   
<script>
  $(document).ready(function(){//影藏所有小选项卡
	$(".list").hide();
	});
$(document).ready(function(){
	 var strUrl=window.location.href;
	var arrUrl=strUrl.split("/");
	var strPage=arrUrl[arrUrl.length-1];
	if(strPage=="jiaosequanxian_servlet"||strPage=="yonghuguanli_servlet"||strPage=="jiaoseguanli_servlet"){
		$("#list4").show();
	}
});

function bar(obj){
	var id="#"+obj;
	var $myli=$(id);
	var info=($myli[0].style.display);
	if(info=="none"){
	$(id).show();
	}else{
	$(id).hide();
	}
}

</script>
 </body>
</html>
