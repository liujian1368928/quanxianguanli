package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Searchdao;
import dao.add_delete_change_dao;
import dao.jiaoseadd_update_delete_dao;
import dao.jiaosecheckdao;
import dao.jiaoseguanlidao;
import dao.jiaosequanxiandao;
import dao.querydatadao;

import entity.Delete;
import entity.add;
import entity.change;
import entity.jiaosecheck;
import entity.jiaoseguanli;
import entity.jiaosequanxian;

public class jiaoseguanli_servlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public jiaoseguanli_servlet() {
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
			//角色管理
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int zongpage=0;
		int pagesize=10;
		String page=request.getParameter("page");
		if(page==null){
			page="1";
		}
		querydatadao query=new querydatadao();
		zongpage=query.getquerydata(pagesize);
		jiaoseguanlidao yhjsdao=new jiaoseguanlidao();
		ArrayList<jiaoseguanli> list=yhjsdao.getyhJiaoSe(Integer.valueOf(page),pagesize);
		
		request.setAttribute("page",page);
		request.setAttribute("zongpage",zongpage);
		request.setAttribute("jiaoseguanli",list);
		request.getRequestDispatcher("jiaoseguanli.jsp").forward(request, response);
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
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		/*	int pagesize=5;
		String page=request.getParameter("page");
		jiaoseguanlidao yhjsdao=new jiaoseguanlidao();
		ArrayList<jiaoseguanli> list=yhjsdao.getyhJiaoSe(Integer.valueOf(page),pagesize);
		for(int i=0;i<5;i++){
			if(i<list.size())
			{
				out.println("<tr>");
				out.println("<td>"+list.get(i).getJid()+"</td>");
			out.println("<td>"+list.get(i).getJid()+"</td>");
			out.println("<td>"+list.get(i).getJiaosemingcheng()+"</td>");
			out.println("<td>"+list.get(i).getBeizhu()+"</td>");
			out.print("<td>");
			out.println("<input type='button' value='编辑' onclick='editer(this,"+list.get(i).getJiaosemingcheng()+")'/>");//"+list.get(i).getJid()+",
			//out.print("<input type='button' value='编辑' onclick='editer(this,"+list.get(i).getJiaosemingcheng()+","+list.get(i).getBeizhu()+")'/>");
			out.println("</td>");
			out.println("</tr>");
			}
		}*/
		int zongpage=0;
		int pagesize=10;
		String page=request.getParameter("page");
		if(page==null){
			page="1";
		}
		querydatadao query=new querydatadao();
		zongpage=query.getquerydata(pagesize);
		request.setAttribute("page",page);
		request.setAttribute("zongpage",zongpage);
		//这里是为了让页面在次获取到总页
		//----------------------------------------------
		String search=request.getParameter("search_text");
		if(search!=null){
		jiaoseguanli suosou=new jiaoseguanli();
		suosou.setJiaosemingcheng(search);
		Searchdao suosoudao=new Searchdao();
		ArrayList<jiaoseguanli> list=suosoudao.search(suosou);
		request.setAttribute("jiaoseguanli",list);
		request.getRequestDispatcher("jiaoseguanli.jsp").forward(request, response);
		}

		String add=request.getParameter("action");
		String zhi="";
	if(add!=null){
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
		out.println(zhi);
	}
		out.flush();
		out.close();
	}
	private String Delete(HttpServletRequest request) {//删除
		String id=request.getParameter("id");
		int jid=Integer.valueOf(id);
		jiaoseadd_update_delete_dao jiaosedelete=new jiaoseadd_update_delete_dao();
		jiaoseguanli js_delete=new jiaoseguanli();
		js_delete.setJid(jid);
		String res=jiaosedelete.Deletedata(js_delete);
		// TODO Auto-generated method stub
			return res;
		}

	private String update(HttpServletRequest request){//更新
		String id=request.getParameter("jid");
		String jiaosemingcheng=request.getParameter("supplier");
		String beizhu=request.getParameter("goods");	
		int jid=Integer.valueOf(id);
		jiaoseadd_update_delete_dao jiaoseupdate=new jiaoseadd_update_delete_dao();
		jiaoseguanli js_update=new jiaoseguanli();
			
			js_update.setJid(jid);
			js_update.setJiaosemingcheng(jiaosemingcheng);
			js_update.setBeizhu(beizhu);
			String res=jiaoseupdate.updatedata(js_update);//插入sj
			return res;
		}
		private String addnew(HttpServletRequest request){//添加
			
			jiaoseadd_update_delete_dao jiaoseadd=new jiaoseadd_update_delete_dao();
			jiaoseguanli js_add=new jiaoseguanli();
			String jiaosemingcheng=request.getParameter("supplier");		
			String beizhu=request.getParameter("goods");		

			js_add.setJiaosemingcheng(jiaosemingcheng);
			js_add.setBeizhu(beizhu);
			String res=jiaoseadd.add(js_add);//插入sj
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
