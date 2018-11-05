<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String zhi=(String)session.getAttribute("username");
if(zhi==null)
{
	response.sendRedirect("login.jsp");
}
%>

