<%@ page language="java" import="java.util.*,entity.check" pageEncoding="utf-8"%>
<%@ include file="LoginControl.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" href="css/main.css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
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
				<form action="check_servlet" method="post" id="search">
				<select>
					<option >供货商</option>
					<option >货品</option>
				</select>
			
				<input type="text" name="search_text" id="search_text"/>
				<input type="submit" value="查找" />
				<input type="button" id="add" value="添加"/>
				</form>
			</div><!-- head结束 -->
			
			<div id="table1">
		   	  <table cellpadding="0" align="center" cellspacing="0" class="list_table">
		                <tr name="table_nav">
		               	  <td>序号</td>
		                   <td>供应商</td>
		                   <td>货品</td>
		                   <td>价格</td>
		                   <td>报价日期</td>
		                   <td>说明</td> 
		              		<td colspan="2">操作</td>
		              	</tr>
		              		
		              		<%
		              		ArrayList<check> list=(ArrayList<check>)request.getAttribute("check");
		              		int i=1;
		              		for(check sj:list)
		              		{
		              		 %>
		              		 <tr class="tr">
		              		 <td><%=i++ %></td>
		              		 <td><%=sj.getSupplier() %></td>
		              		  <td><%=sj.getGoods() %></td>
		              		  <td><%=sj.getPrice() %></td>
		              		  <td><%=sj.getDate() %></td>
		              		  <td><%=sj.getShuoming() %></td>
		              		  <td align="center"><input type="button" value="编辑" onclick="editer(this,'<%=sj.getId() %>','<%=sj.getSupplier() %>','<%=sj.getGoods() %>','<%=sj.getPrice() %>','<%=sj.getDate() %>','<%=sj.getShuoming() %>')"/></td>
		              		  <!-- , -->
		              		  <td align="center"><input type="button" value="删除" onclick="Delete('<%=sj.getId() %>')"/></td>
		              		 </tr>
		              		 <%	} %>
		              <tr >
		             	 <td class="td" align="center" colspan="7"></td>
		         
		              </tr>
		                     
		            
		         </table>
				  <div class="page">
				      <span>1</span>
				      <span>2</span>
				      <span>3</span>
				      <span>....</span>   
				      <span>8</span>
				   </div>
			</div><!-- table1结束 -->
			<div id="windows">
				<form method="post" action="" id="form" >
					<table class="form_table" align="center" border="0" cellpadding="0" cellspacing="0" >
			  			 <tr>
			                  <td colspan="2" style="font-size:25px;color:red;">采购报价</td>
			             </tr> 
			              <tr>
			                  <td ><input type="hidden" id="id" name="id"  class="input-text lh25" size="10"></td>
			             </tr>
			             <tr>
			                  <td >供应商</td>
			                  <td ><input type="text" id="supplier" name="supplier"  class="input-text lh25" size="10"></td>
			             </tr>
			                  <!-- 字符左对齐，单字符居中 ，单数字右对齐 -->
			             <tr>
			                 <td >货品</td>
			                 <td ><input type="text" id="goods" name="goods"  class="input-text lh25" size="10"></td>             
			             <tr>
			                  <td >价格</td>
			                  <td ><input type="text" id="price" name="price" class="input-text lh25" size="10"></td>
						</tr>
						
						<tr>
			                  <td>报价日期</td>
			                  <td><input type="text" id="date" name="date" class="input-text lh25" size="10"></td>
			            </tr>
			                  <td>说明</td>
			                  <td><input type="text" id="shuoming" name="shuoming"class="input-text lh25" size="10"></td>
			            </tr>
			            
			            <tr>  
							  <td align="right"><input type="button" class="input-submit lh25"  id="value" value="添加" onclick="liujian()"/></td> <!-- 有添加和修改功能 -->
							  <td align="right"><input type="button" class="input-text lh25" value="关闭" id="close"/></td>
			            </tr> 
			          </table>
			      </form>
			</div><!-- windows结束 -->
			
	</div>
</div>
</body>
</html>
