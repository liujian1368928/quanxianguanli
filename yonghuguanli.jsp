<%@ page language="java" import="java.util.*,entity.yonghuguanli" pageEncoding="utf-8"%>
<%@ page  import="entity.jiaosecheck" %>
<%@ include file="LoginControl.jsp" %>
<%String  value=String.valueOf(request.getAttribute("zongpage"));
String value2=String.valueOf(request.getAttribute("page"));
int zongpage=Integer.valueOf(value);
int Page=Integer.valueOf(value2); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" href="css/main.css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/yonghuguanli-ajax.js"></script>

</head>
<body>
<div id="container">
		 
		  <div id="index">
			<jsp:include page="index2.jsp"></jsp:include>
		  </div><!-- index结束 -->
		  
		<div id="rightpage">
			<div id="fugai">
			</div>
			<div id="input">
				<form action="yonghuguanli_servlet" method="post" id="search">
			<!-- 	<select>
					<option >供货商</option>
					<option >货品</option>
				</select>
			-->	
				当前第<%=Page %>页
				总共<%=zongpage %>页
				<input type="text" name="search_text" id="search_text"/>
				<input type="submit" value="查找" />
				<input type="button" id="add" value="添加"/>
				</form>
			</div><!-- head结束 -->
				
			<div id="table1">
		   	  <table cellpadding="0" align="center" cellspacing="0" class="list_table">
		                <tr name="table_nav">
		               	   <td align="center">序号</td>
		                   <td>用户名称</td>
		                   <td>用户密码</td>
 							<td>所属角色</td>
		              		<td colspan="2">操作</td>
		              	</tr>      		 
		              		<% ArrayList<yonghuguanli> list=(ArrayList<yonghuguanli>)request.getAttribute("yonghuguanli");
		          			 int j=1;
		           		for(int i=0;i<10;i++){
		           			if(i<list.size()){
		            %>
		            <tr class="tr">
		            <td><%=j++ %></td>
		            <td><%=list.get(i).getYonghumingcheng() %></td>
		             <td><%=list.get(i).getYonghumima()%></td>
		             <td><%=list.get(i).getJiaosemingcheng() %></td>
		             <td align="center"><input type="button" value="编辑" onclick="editer(this,'<%=list.get(i).getYonghumingcheng() %>','<%=list.get(i).getYonghumima() %>','<%=list.get(i).getYonghuid()%>','<%=list.get(i).getJiaosemingcheng()%>')"/></td>
		              		  <!-- , -->
		              		  <td align="center"><input type="button" value="删除" onclick="jiaoseDelete('<%=list.get(i).getYonghuid() %>')"/></td>
		             </tr>
		            		<%} else{%>
		            		<tr>
		            		<td></td>
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
				  <div class="pagebutton">
				    <a href="yonghuguanli_servlet?page=1" >首页</a>
					<a href="yonghuguanli_servlet?page=<%if(Page-1<1){out.println("1");}else{out.println(Page-1);} %>" onclick="huanye('shang')">上一页</a>
					<a href="yonghuguanli_servlet?page=<%if(Page+1>zongpage){
					out.println(zongpage);}else{
					out.println(Page+1);} %>" onclick="huanye('xia')">下一页</a>
					<a href="yonghuguanli_servlet?page=<%out.println(zongpage); %>" onclick="huanye('lastpage')">末页</a>
				   </div>
			</div><!-- table1结束 -->
		<div id="windows">
				<form method="post" action="" id="form" onchage >
					<table class="form_table" align="center" border="0" cellpadding="0" cellspacing="0" >
			  			 <tr>
			                  <td colspan="2" style="font-size:25px;color:red;">用户编辑</td>
			             </tr> 
			               <tr>
			 
			                  <td ><input type="hidden" id="jid" name="jid"  class="input-text lh25" size="10"></td>
			             </tr>
			             <tr>
			                  <td >用户名称</td>
			                  <td ><input type="text" id="supplier" name="supplier"  class="input-text lh25" size="10"></td>
			             </tr>
			                  <!-- 字符左对齐，单字符居中 ，单数字右对齐 -->
			             <tr>
			                 <td >用户密码</td>
			                 <td ><input type="text" id="goods" name="goods"  class="input-text lh25" size="10"></td>             
			            <tr> 
			             <tr>
			                 <td ><input type="hidden" id="yonghuid" name="yonghuid"  class="input-text lh25" size="10"></td>             
			            <tr> 
			             <tr>
			                 <td >所属角色</td>
			                 <td >  
			                 <select id="selectjiaose" name="selectjiaose"> 
			               		 <option class="mingcheng" value="0"></option>
			               		
			                  <%  ArrayList<jiaosecheck> jslist=(ArrayList<jiaosecheck>)request.getAttribute("jiaoseguanli"); 
		      					 for(jiaosecheck js:jslist){
		      					%>
			                   <option  value="<%=js.getJid()%>"><%=js.getJiaosemingcheng()%> </option>
			                 <% }%>
			                   </select>
			                 </td>             
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
$(document).ready(function(){
$("#add").click(function(){//添加按钮 
		$("#windows").show();//显示覆盖层和窗口
		$("#fugai").show();
		$("html").css('overflow','hidden');//弹窗后的背景不溢出
		$("#value").val("添加");
		$("#form input[type='text']").val("");	
	});
	});
$(document).ready(function(){
$("#close").click(function(){//关闭覆盖层和窗口
		$("#windows").hide();
		$("#fugai").hide();
		$("html").css('overflow','auto');
	});
});

	function editer(editer,supplier,goods,yonghuid,jiaosemingcheng)/*编辑按钮方法*/
	{

		$("#windows").show();
		$("#fugai").show();
		$("#value").val("修改");
			$("html").css('overflow','hidden');
		//$("#id").val(id);
		$("#supplier").val(supplier);
		$(".mingcheng").text(jiaosemingcheng);
		$("#goods").val(goods);
		$("#yonghuid").val(yonghuid);
		//$("#jiaose").val(jiaose);
	}	
		$(document).ready(function(){	//当页面数据为空时
			if($(".tr td").text()==""||$(".tr td").text()==null)
				{
					$(".td").show();	
					$(".td").css({"color":"red"});
					$(".td").text("----当前搜索数据为空或者还没有数据哦----");	
				}
				else
				{
					$(".td").hide();	
				}
		});
function liujian()
	{		
		var text=$("#form input[type='text']");
		var option=$("#selectjiaose option");
		for(var i=1;i<text.length;i++)
		{
			if(text[i].value=="")
			{
				alert("请不要留空");
				return false;
			}		
			else
			{
				//不为空则执行添加	
				if($("#value").val()=="添加"	)
					{
						$(function(){//("#value").click由于外面有点击就事件liujian在加一个多余
						onclick=yonghuadd();
						});
					}
				else if($("#value").val()=="修改")
				{
					$(function(){
						onclick=yonghuupdate();
						});
				}
				return true;
			}
		}
	} 
</script>
</body>
</html>
