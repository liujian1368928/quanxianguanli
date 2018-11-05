package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.checkmanager;

import dao.add_delete_change_dao;
import dao.checkdao;
import entity.Delete;
import entity.add;
import entity.check;
import entity.change;

public class add_delete_change_cheak extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public add_delete_change_cheak() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String add=request.getParameter("action");
		String zhi="";
		if(add.equals("addnew"))
		{
			zhi=addnew(request);
		}
		else if(add.equals("update"))
		{
			zhi=update(request);
		}
		else if(add.equals("Delete"))
		{
			zhi=Delete(request);	
		}	
		out.print(zhi);
	}

private String Delete(HttpServletRequest request) {/*删除*/
	String id=request.getParameter("id");
	int zhi=Integer.valueOf(id);
	Delete sj=new Delete();
	add_delete_change_dao del=new add_delete_change_dao();
	sj.setId(zhi);
	String res=del.Deletedata(sj);
	// TODO Auto-generated method stub
		return res;
	}

private String update(HttpServletRequest request){/*更新*/
	String id=request.getParameter("id");
	String supplier=request.getParameter("supplier");
	String goods=request.getParameter("goods");
	String price=request.getParameter("price");
	String date=request.getParameter("date");	
	String shuoming=request.getParameter("shuoming");	
		change sj=new change();
		int zhi=Integer.valueOf(id);
		sj.setId(zhi);
		sj.setSupplier(supplier);
		sj.setGoods(goods);
		sj.setPrice(price);
		sj.setDate(date);
		sj.setShuoming(shuoming);
		add_delete_change_dao cr=new add_delete_change_dao();
		String res=cr.updatedata(sj);//插入sj
		return res;
	}
	private String addnew(HttpServletRequest request){/*添加*/
		
		add_delete_change_dao cr=new add_delete_change_dao();
		add sj=new add();
		String supplier=request.getParameter("supplier");		
		String goods=request.getParameter("goods");		
		String price=request.getParameter("price");	
		String date=request.getParameter("date");	
		String shuoming=request.getParameter("shuoming");	
		sj.setSupplier(supplier);
		sj.setGoods(goods);
		sj.setPrice(price);
		sj.setDate(date);
		sj.setShuoming(shuoming);
		String res=cr.adddata(sj);//插入sj
		return res;
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
