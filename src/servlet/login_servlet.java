package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Logindao;

public class login_servlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public login_servlet() {
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

		response.setContentType("text/html");
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
		String action=request.getParameter("action");
		String zhi = null;
	if(action.equals("yanzheng"))
	{
		zhi=yanzheng(request);
		
	}else if(action.equals("login"))
	{
		String[] res;
		HttpSession session=request.getSession();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Logindao login=new Logindao();
		res=login.Login(username, password);
		session.setAttribute("zhiwei",res[1]);
		session.setAttribute("jid", res[0]);//传给menu-servlet
		session.setAttribute("username",username);
		menu_servlet ser=new menu_servlet();//调用Menu生成权限列表
		ser.doPost(request, response);
	}
		out.print(zhi);	
		out.flush();
		out.close();
	}

	private String yanzheng(HttpServletRequest request) {
		//ajax验证帐号是否存在
		// TODO Auto-generated method stub
		String zhi;
		String username=request.getParameter("username");
		Logindao data=new Logindao();
		zhi=data.yanzheng(username);
		 if(zhi.equals("验证失败")==true){
			 zhi="帐号"+username+"不存在";
		 }
		return zhi;
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
