<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>
<link rel="stylesheet" href="css/main2.css" />
<script src="js/jquery-1.8.3.js"></script>
<script src="js/main2.js"></script>
<body>

<div id="container">
		  <div id="index">
				<jsp:include page="index2.jsp"></jsp:include>
		  </div>
		  <div id="rightpage">
		  	<div id="fugai">
				</div>
			<div id="input">
					<select>
					<option >采购单号</option>
					<option >客户</option>
					<option >型号</option>
					</select>
					<input type="text"/>
					<input type="button" value="查找"/>
					<input type="button" id="add" value="添加"/>
			</div>
	<div id="table1">
              <table align="center" width="1000px"cellpadding="0" cellspacing="0" class="list_table">
                <tr name="table_nav">
                   <td >采购单号</td>
                   <td>采购日期</td>
                   <td>客户</td>
                   <td>采购员</td>
                   <td>数量</td>
                   <td>颜色</td>
                   <td>规格</td>
                   <td>型号</td>
                   <td>单位</td>
              		<td colspan="2">操作</td>
              		</tr>
              		<tr ><td class="td" colspan="10" align="center"></td></tr>
                   
                <tr class="tr">
                 
                 <td align="left"></td>
                 <td align="left"></td>
                 <td align="left"></td>
                 <td align="left"></td>
                   <td align="left"></td>
                   <td align="left"></td>
                   <td align="left"></td>
                    <td align="left"></td>
                    <td align="left"></td>
                    <td align="center"><input type="button" value="编辑" onclick="editor(this)"/> </td> 
                    <td align="center" ><input type="button" value="删除" onclick="_delete(this)"/></td><!-- 改为其他的卡住 -->
                     
                 </tr>
                
              </table>
                <div class="page">
                <span>1</span>
                <span>2</span>
                <span>3</span>
                 <span>....</span>   
                <span>8</span>
                </div>
              </div>
<div id="windows">
<form method="post" action="" id="add" onsubmit="return liujian()">
<table class="form_table" border="0" cellpadding="0" cellspacing="0"> 
                 <tr>
               <td colspan="2" style="font-size:35px;color:red;">采购订单</td>
                  </tr> 
                  
                  <tr>
                  <td >采购单号</td>
                  <td ><input type="text" id="number" name="name"  class="input-text lh25" size="10"></td>
                  </tr>
                  
                  <!-- 字符左对齐，单字符居中 ，单数字右对齐 -->
                  <tr>
                  <td >采购日期</td>
                 <td ><input type="text" id="customer" name="year"  class="input-text lh25" size="10"></td>    
                 	</tr>         
                        <tr>
                  <td >客户</td>
                  <td ><input type="text" id="sex" name="sex" class="input-text lh25" size="10"></td>
						</tr>
						
						<tr>
                   <td>采购员</td>
                  <td><input type="text" id="major" name="major" class="input-text lh25" size="10"></td>
                     </tr>
                         <tr>
                     <td>数量</td>
                  <td><input type="text" id="major" name="major"class="input-text lh25" size="10"></td>
                     </tr>
                         <tr>
                     <td>颜色</td>
                  <td><input type="text" id="major" name="major"  class="input-text lh25" size="10"></td>
                     </tr>
                         <tr>
                     <td>规格</td>
                  <td><input type="text" id="major" name="major" class="input-text lh25" size="10"></td>
                     </tr>
                         <tr>
                     <td>型号</td>
                  <td><input type="text" id="major" name="major"  " class="input-text lh25" size="10"></td>
                     </tr>
                         <tr>
                     <td>单位</td>
                  <td><input type="text" id="major" name="major"  class="input-text lh25" size="10"></td>
                     </tr>
                     
                     <tr>  
						<td align="right"><input type="submit"  class="input-submit"  value="添加"  /></td> 
						<td align="center"><input type="button" class="input-text lh25" value="关闭" id="close"/></td>
                     </tr>
             	 </table>
       		</form>
         </div>
   </div>
</div>
<script>
$(document).ready(function(){	
if($(".tr td").text()==""||$(".tr td").text()==null)
	{
	$(".td").show();	
	$(".td").css({"color":"red","text-align":"center"});
	$(".td").text("----当前数据为空哦----");	
	}
	else
	{
	$(".td").hide();	
	}
})


</script>
</body>
</html>
