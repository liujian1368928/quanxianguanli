package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.fenyemana;

import dao.shangpinfenleidao;
import entity.ajaxfenye;
import entity.dalie;
import entity.shangpinquery;

public class ajaxfenye_servlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ajaxfenye_servlet() {
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
		fenyemana fyma=new fenyemana();
		ArrayList<dalie> list=fyma.fenyeman();
		//返回数据;
		int pagesize=10;
		int zongyeshu=0;
		String pageno=request.getParameter("pageno");
		if(pageno==null)
		{
			pageno="1";
		}
	/*	fenyedao fydao=new fenyedao();
		zongyeshu=fydao.getpage(pagesize);
		request.setAttribute("zongyeshu",zongyeshu);//总页数*/
		request.setAttribute("list", list);
		request.getRequestDispatcher("shangpinguanli.jsp").forward(request, response);
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
		int zongyeshu=0;
		String pageno=request.getParameter("pageno");//当前页数
		String pagesize=request.getParameter("selectpagesize");//每页显示的页数
		//String leibeiname=request.getParameter("leibeiname");//当前点击的类别名称
		String leibeimingcheng=request.getParameter("typeid");//所选的分类 
		String search=request.getParameter("search");
		System.out.println(pagesize+","+leibeimingcheng+","+pageno);
		String lbmc="";
		String lbid="";	
		if(leibeimingcheng.equals("all,all"))
		{
			lbmc="all";
			lbid="";
		}else{
			String[] arr=leibeimingcheng.split(",");//分割成字符数组
			lbmc=arr[0];
		    lbid=arr[1];
		}
		if(pageno==null)
		{
			pageno="1";
		}
		ajaxfenye fenye=new ajaxfenye();
		//将entity.ajaxfenye中改为Int,这里用integer.valueof会报错
		fenye.setLeibeimingcheng(lbmc);
		fenye.setLeibeimingchengid(lbid);
		fenye.setPageno(Integer.valueOf(pageno));
		fenye.setPagesize(Integer.valueOf(pagesize));
		fenye.setSearch(search);
		
		shangpinfenleidao fldao=new shangpinfenleidao();
		ArrayList<shangpinquery> list=fldao.getspfl(fenye);
		zongyeshu=fldao.getpage(fenye);
		for(int i=0;i<Integer.valueOf(pagesize);i++)
		{
			if(i<list.size()){
			out.println("<tr>");
			out.println("<td>"+list.get(i).getPingming()+"</td>");
			out.println("<td>"+list.get(i).getGuige()+"</td>");
			out.println("<td>"+list.get(i).getJiage()+"</td>");
			out.println("</tr>");
			}
			else{
				out.println("<tr>");
				out.print("<td>&nbsp</td><td>&nbsp</td><td>&nbsp</td>");
				out.println("</tr>");
			}
		}
		out.println("<script>$('.lastpage').val("+zongyeshu+")</script>");
		out.flush();
		out.close();
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
