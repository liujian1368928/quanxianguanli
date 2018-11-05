package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.checkdao;

import entity.Search;
import entity.check;

import manager.checkmanager;

public class check_servlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public check_servlet() {
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
		checkmanager mana=new checkmanager();
		List<check> list=mana.getallkehu();
		request.setAttribute("check",list);
		request.getRequestDispatcher("/main.jsp").forward(request,response);
		out.flush();
		out.close();
	/*	response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		checkmanager mana=new checkmanager();
		List<check> list=mana.getallkehu();
		request.setAttribute("check",list);
		request.getRequestDispatcher("/main.jsp").forward(request,response);
		out.flush();
		out.close();*/
	/*	if(search.equals("search"))
		{
			search(request);
		}*/
		//Search Search=new Search();
	//	Search.setSearch(search);
		//checkdao dao=new checkdao();
	//	List<check> list=dao.search(Search);
		//request.setAttribute("kehu",list);
	//	request.getRequestDispatcher("/index.jsp").forward(request,response);
		
		
	
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
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
 		String search=request.getParameter("search_text");
		check Search=new check();
		checkdao dao=new checkdao();
		Search.setSearch(search);
		List<check> list=dao.search(Search);
		request.setAttribute("check",list);
		request.getRequestDispatcher("/main.jsp").forward(request,response);
		//for(check ls:list){
		//out.println(ls.getSupplier()+ls.getGoods());
			 //out.print(ls.getSupplier());
	//	}
		//out.print("<table cellpadding='0' align='center' cellspacing='0' class='list_table'><tr name='table_nav'>");
		//	out.print("<td>序号</td><td>供应商</td><td>货品</td><td>价格</td><td>报价日期</td><td>说明</td><td colspan='2'>操作</td></tr>");
			
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
