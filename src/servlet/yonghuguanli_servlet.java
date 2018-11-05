package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Searchdao;
import dao.jiaoseadd_update_delete_dao;
import dao.jiaosecheckdao;
import dao.querydatadao;
import dao.yonghuadd_update_delete_dao;
import dao.yonghuguanlidao;
import entity.jiaosecheck;
import entity.jiaoseguanli;
import entity.yonghuguanli;


public class yonghuguanli_servlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public yonghuguanli_servlet() {
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
		int zongpage=0;
		int pagesize=10;
		String page=request.getParameter("page");
		if(page==null){
			page="1";
		}
		querydatadao query=new querydatadao();
		zongpage=query.getqueryyhdata(pagesize);
		
		//返回用户数据
		yonghuguanlidao yhgldao=new yonghuguanlidao();
		ArrayList<yonghuguanli> list=yhgldao.getyhgl(Integer.valueOf(page),pagesize);
		
		//查寻系统所有角色
		jiaosecheckdao yhjsdao=new jiaosecheckdao();
		ArrayList<jiaosecheck> list2=yhjsdao.getyhJiaoSe();
		request.setAttribute("page",page);
		request.setAttribute("zongpage",zongpage);
		request.setAttribute("yonghuguanli", list);
		request.setAttribute("jiaoseguanli",list2);
		request.getRequestDispatcher("yonghuguanli.jsp").forward(request, response);
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
		//这里是为了让页面在次获取到页面分页数据
		//----------------------------------------------
		jiaosecheckdao yhjsdao=new jiaosecheckdao();
		ArrayList<jiaosecheck> list2=yhjsdao.getyhJiaoSe();
		request.setAttribute("jiaoseguanli",list2);
		//这里又调用jiaose里的数据
		//----------------------------------------------
		String search=request.getParameter("search_text");
		if(search!=null){
		yonghuguanli suosou=new yonghuguanli();
		suosou.setYonghumingcheng(search);
		Searchdao suosoudao=new Searchdao();
		ArrayList<yonghuguanli> list=suosoudao.search(suosou);
		request.setAttribute("yonghuguanli",list);
		request.getRequestDispatcher("yonghuguanli.jsp").forward(request, response);
		}
		//----------------------------------------------
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
	String res=null;
	private String Delete(HttpServletRequest request) {//删除
		String id=request.getParameter("id");
		int yonghuid=Integer.valueOf(id);
		yonghuadd_update_delete_dao yhgl_delete=new yonghuadd_update_delete_dao();
		yonghuguanli yonghu_delete=new yonghuguanli();
		 yonghu_delete.setYonghuid(yonghuid);
		 
		String res=yhgl_delete.Deletedata(yonghu_delete);
		// TODO Auto-generated method stub
			return res;
		}

	private String update(HttpServletRequest request){//更新
		String yonghumingcheng=request.getParameter("supplier");
		String yonghumima=request.getParameter("goods");	
		String id=request.getParameter("selectjiaose");
		String yonghuid=request.getParameter("yonghuid");
		
		yonghuadd_update_delete_dao yhglupdate=new yonghuadd_update_delete_dao();
		yonghuguanli yonghu_update=new yonghuguanli();
		
			int jid=Integer.valueOf(id);
			int yhid=Integer.valueOf(yonghuid);
			yonghu_update.setJid(jid);
			yonghu_update.setYonghumingcheng(yonghumingcheng);
			yonghu_update.setYonghumima(yonghumima);
			yonghu_update.setYonghuid(yhid);
			String res=yhglupdate.updatedata(yonghu_update);//插入sj
			return res;
		}
	
		private String addnew(HttpServletRequest request){//添加
			yonghuadd_update_delete_dao yhgldao=new yonghuadd_update_delete_dao();
			//yonghuguanli_add yonghuadd=new yonghuguanli_add();
			yonghuguanli yonghu_add=new yonghuguanli();
			String yonghumingcheng=request.getParameter("supplier");
			String yonghumima=request.getParameter("goods");	
			String jiaose=request.getParameter("selectjiaose");
			int jid=Integer.valueOf(jiaose);
			yonghu_add.setYonghumingcheng(yonghumingcheng);
			yonghu_add.setYonghumima(yonghumima);
			yonghu_add.setJid(jid);
			res=yhgldao.adddata(yonghu_add);
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
