<%@ page language="java" import="java.util.*,entity.dalie" pageEncoding="utf-8"%>
<%@ page language="java" import="entity.xiaolie"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script>
  function leibiedianji(type,id,lbname){
  var value=type+","+id;
  $(".pageno").val("1");
  	$("#leibiename").text(lbname);
  	$("#typeid").val(value);
  	fenye();
  }

  function huanye(obj)
  { var page=$(".pageno").val();
	var lastpage=$(".lastpage").val();
	  if(obj=="first")
	  {
	 	$(".pageno").val(1);
	 	fenye();
	  }else if(obj=="previou")
	  {
	   page=page-1;
	    if(page==0)
		  {
		  page=1;
		  }
		  $(".pageno").val(page);
		fenye();
	  }else if(obj=="next")
	  {
		  if(page!="")
			  {
		page=parseInt(page)+1;
	    $(".pageno").val(page);
			  }
			  if(page>lastpage)
			{
			$(".pageno").val(lastpage);
			}
			
			fenye();
	  }else if(obj=="lastpage")
	  {
			 $(".pageno").val(lastpage);
	 	fenye();
	  }
	
  }
  function fenye(){
  var url="ajaxfenye_servlet";
  var data=$("#fenye").serialize();
			$.ajax({
				url:url,
				data:data,
				type:"post",
				dataType:"text",
				success: function(result) {
					//alert(result);
					$("#a").html(result);
				},
				error : function() { //请求失败后要执行的代码
				
				}				
			});		

  }
 
  </script>
  <style>
  #head{
  width:auto;
  height:auto;
text-align:center
  }
 .ul{
 float:left;
  width:auto;
  height:auto;
  padding:0;
margin-left:300px;
  }
  li{
  list-style:none;
  }
#a{
  float:left;
width:auto;
height:auto;
margin-top:20px;
margin-left:20px;
  }
  #a td{
  width:150px;
  text-align:center;
 border:1px solid blue;
border-collapse:collapse;  
border-spacing:0;  
  
  }
 #page{
 width:auto;

 }
  </style>
  <body>
  <div id="container">

		  <div id="index">
			<jsp:include page="index2.jsp"></jsp:include>
		  </div><!-- index结束 -->
		  
<div id="head">
  <form action="" method="post" id="fenye">
  <span id="leibiename" name="leibiename"></span>
  <input type="hidden" size="10" name="typeid" id="typeid">
  <input type="text" name="search">
  <input type="button" onclick="fenye()" value="搜索">
<select name="selectpagesize" onchange="fenye()">
<option value="5">显示5条数据</option>
<option value="10">显示10条数据</option>
<option value="20">显示20条数据</option>
</select>
第 <input type="text" name="pageno" class="pageno" style="width:20px;border:none;">页
总 <input type="text"  name="lastpage" class="lastpage" style="width:20px;border:none">页
  </form>
      
</div>
 <ul class="ul">
 <li style="font-size:25px;"><a href="#" onclick="leibiedianji('all','all')"  >所有数据</a></li>
	  <% ArrayList<dalie> list=(ArrayList<dalie>)request.getAttribute("list"); 
 	for(dalie sj:list){%> 
	 <li style="font-size:20px;"><a href="#" onclick="return leibiedianji('F',<%=sj.getLbid()%>,'<%=sj.getLbmingcheng()%>')"><%=sj.getLbmingcheng() %></a></li>
		 <ul >
		 	 <%ArrayList<xiaolie> list2=sj.getXiaolie();
		 for(xiaolie xlsj:list2){ %>
		 <li style="font-size:15px;padding-left:15px;"><a href="#" onclick="return leibiedianji('C',<%=xlsj.getXlid()%>,'<%=xlsj.getXlmingcheng() %>')"><%=xlsj.getXlmingcheng() %></a></li>
		 <%} %>
		 </ul>
		  <%}%>
	 </ul>
  <table border="0"  cellspacing="0" >
 <tbody id="a">

 </tbody>
   <div id="page">
 <a href="#" onclick="huanye('first')">首页</a>
     <a href="#" onclick="huanye('previou')">上一页</a>
     <a href="#" onclick="huanye('next')">下一页</a>
     <a href="#" onclick="huanye('lastpage')">最后一页</a> 
     </div>
 <!--<tr>  
 <%--
    for(int j=1;j<=lastpage;j++) {
      //out.println("<a href='fenye_servlet?pageno="+i+"'>"+i+"页"</a>");
      out.println("<a href=ajaxfenye_servlet?pageno="+j+">"+"第"+j+"页"+"</a>");
       // out.print("&nbsp;&nbsp;<a href='page.jsp?pageq=" + j + "'>" + "页码"+j+/*显示页码*/ "</a>");
      --%>
    <%--} --%>
</tr>-->
  </table>

</div>
  </body>
</html>
