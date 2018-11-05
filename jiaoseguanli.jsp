<%@ page language="java" import="java.util.*,entity.jiaoseguanli" pageEncoding="utf-8"%>
<%@ include file="LoginControl.jsp" %>
<%
String  value=String.valueOf(request.getAttribute("zongpage"));
String value2=String.valueOf(request.getAttribute("page"));
int zongpage=Integer.valueOf(value);
int Page=Integer.valueOf(value2);
%>	

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" href="css/main.css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jiaoseguanli-ajax.js"></script>

</head>
<script>
/*$(function(){
var zongpage=
$(".zongpage").text(zongpage);
});
function huanye(obj)
{
var page=$(".page").val();
var zongpage=;
}
	if(obj=="first")
	{
		page=1;
		$(".page").val(page);
		ajax();
	}
	if(obj=="shang"){
	page=parseInt(page)-1;
		if(page==0){
		page=1;
		}
	$(".page").val(page);
	ajax();
	}
	if(obj=="xia"){
	page=parseInt(page)+1;
		if(page>zongpage){
		page=zongpage;
		}
	$(".page").val(page);
		ajax();
	}
	if(obj=="lastpage"){
		page=zongpage;
		$(".page").val(page);
			ajax();
	}

}
function ajax(){
	var url="jiaoseguanli_servlet";
  var data=$("#fenye").serialize();
			$.ajax({
				url:url,
				data:data,
				type:"post",
				dataType:"text",
				success: function(result) {
					//alert(result);
					$(".list").html(result);
				},
				error : function() { //请求失败后要执行的代码
				
				}				
			});		

}*/
</script>
<body>
<div id="container">
		 
		  <div id="index">
			<jsp:include page="index2.jsp"></jsp:include>
		  </div><!-- index结束 -->
		  
		<div id="rightpage">
			<div id="fugai">
			</div>
			<div id="input">
				<form action="jiaoseguanli_servlet" method="post" id="fenye">
				当前第<%=Page %>页
				总共<%=zongpage %>页
				<input type="text" name="search_text" id="search_text" placeholder="空白时点击显示所有数据"/>
				<input type="submit" value="查找" />
				<input type="button" id="add" value="添加"/>
				</form>
			</div><!-- head结束 -->
			
			<div id="table1">
		   	  <table cellpadding="0" align="center" cellspacing="0" class="list_table">
		                <tr name="table_nav">
		               	   <td >序号</td>
		                   <td>角色名称</td>
		                   <td>备注</td>

		              		<td colspan="2">操作</td>
		              	</tr>
		           <%    	ArrayList<jiaoseguanli> list=(ArrayList<jiaoseguanli>)request.getAttribute("jiaoseguanli");
		           int j=1;
		           		for(int i=0;i<10;i++){
		           			if(i<list.size()){
		            %>
		            <tr class="tr">
		            <td><%=j++ %></td>
		            <td><%=list.get(i).getJiaosemingcheng() %></td>
		             <td><%=list.get(i).getBeizhu()%></td>
		             <td align="center"><input type="button" value="编辑" onclick="editer(this,'<%=list.get(i).getJid() %>','<%=list.get(i).getJiaosemingcheng() %>','<%=list.get(i).getBeizhu()%>')"/></td>
		              		  <!-- , -->
		              		  <td align="center"><input type="button" value="删除" onclick="jiaoseDelete('<%=list.get(i).getJid() %>')"/></td>
		             </tr>
		            		<%} else{%>
		            		<tr>
		            		<td></td>
		            		<td></td>
		            		<td></td>
		            		<td></td>
		            		<td></td>
		            		</tr>
					  <%}} %>
		              <tr >
		             	 <td class="td" align="center" colspan="7"></td>
		              </tr>
		         </table>
				      <DIV class="pagebutton">
					<a href="jiaoseguanli_servlet?page=1" >首页</a>
					<a href="jiaoseguanli_servlet?page=<%if(Page-1<1){out.println("1");}else{out.println(Page-1);} %>" onclick="huanye('shang')">上一页</a>
					<a href="jiaoseguanli_servlet?page=<%if(Page+1>zongpage){
					out.println(zongpage);}else{
					out.println(Page+1);} %>" onclick="huanye('xia')">下一页</a>
					<a href="jiaoseguanli_servlet?page=<%out.println(zongpage); %>" onclick="huanye('lastpage')">末页</a>
				   </DIV>
			</div><!-- table1结束 -->
			<div id="windows">
				<form method="post" action="" id="form" >
					<table class="form_table" align="center" border="0" cellpadding="0" cellspacing="0" >
			  			 <tr>
			                  <td colspan="2" style="font-size:25px;color:red;">角色编辑</td>
			             </tr> 
			               <tr>
			 
			                  <td ><input type="hidden" id="jid" name="jid"  class="input-text lh25" size="10"></td>
			             </tr>
			             <tr>
			                  <td >角色名称</td>
			                  <td ><input type="text" id="supplier" name="supplier"  class="input-text lh25" size="10"></td>
			             </tr>
			                  <!-- 字符左对齐，单字符居中 ，单数字右对齐 -->
			             <tr>
			                 <td >备注</td>
			                 <td ><input type="text" id="goods" name="goods"  class="input-text lh25" size="10"></td>             
			         
			            
			            <tr>  
							  <td align="right"><input type="button" class="input-submit lh25"  id="value" value="添加" onclick="liujian()"/></td> <!-- 有添加和修改功能 -->
							  <td align="right"><input type="button" class="input-text lh25" value="关闭" id="close"/></td>
			            </tr> 
			          </table>
			      </form>
			</div><!-- windows结束 -->
			
	</div>
</div>
<script>

	  		
</script>
</body>
</html>
