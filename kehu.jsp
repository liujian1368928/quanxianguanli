<%@ page language="java" import="java.util.*,entity.check,entity.menu" pageEncoding="utf-8"%>

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
				<select>
					<option >名称</option>
					<option >编号</option>
				</select>
				
				<input type="text"/>
				<input type="button" value="查找"/>
				<input type="button" id="add" value="添加"/>
			</div><!-- head结束 -->
			
			<div id="table1">
		   	  <table cellpadding="0" align="center" cellspacing="0" class="list_table">
		                <tr name="table_nav">
		               	   <td>客户编号</td>
		                   <td>客户名称</td>
		                   <td>客户全称</td>
		                   <td>客户地址</td>
		                   <td>Email</td>
		                   <td>电话</td>
		              		<td colspan="2">操作</td>
		              	</tr>
		              		
		              <tr >
		             	 <td class="td" align="center" colspan="7"></td>
		              </tr>
		                   <tr class="tr">
		               	   <td align="center">001</td>
		                   <td align="center">魅族</td>
		                   <td align="left">魅族科技有限公司</td>
		                   <td align="left">广东省珠海市唐家湾科技创新海岸魅族科技楼</td>
		                   <td align="left">MZ_KF@meizu.com</td>
		                   <td align="center">0743-123456</td>
		                   <td align="center"><input type="button" value="编辑" onclick="editer()"/> </td> 
		                   <td align="center" ><input type="button" value="删除"  onclick="Delete()" /></td>  
		                </tr>   
		            
		                <%  Object sj=request.getAttribute("check");
		                List<check> list=(List<check>)sj;
		                if(sj!=null){
		                int i=1;
		              for(check Check:list){
		                %>    
		               <tr class="tr">
		                <td align="center"><%=i++ %></td>
		                   <td align="center"><%=Check.getSupplier() %></td>
		                   <td align="left"><%=Check.getGoods() %></td>
		                   <td align="right"><%=Check.getPrice() %></td>
		                   <td align="left"><%=Check.getDate() %></td>
		                   <td align="center"><%=Check.getShuoming() %></td>
		                   <td align="center"><input type="button" value="编辑" onclick="editer(this,'<%=Check.getId() %>','<%=Check.getSupplier()%>','<%=Check.getGoods() %>','<%=Check.getPrice() %>','<%=Check.getDate() %>','<%=Check.getShuoming() %>')"/> </td> 
		                   <td align="center" ><input type="button" value="删除"  onclick="Delete(<%=Check.getId() %>)" /></td>  
		                </tr>
		                 <%
		                 	}
		                 } %>
		             
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
