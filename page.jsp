<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; 
     charset=UTF-8"
    pageEncoding="UTF-8" info="this is the company platform index page"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>company</title>
</head>

<body>

    <div class="container">
        <div class="cplist" id="cplistheight">
            <table>
                <%
                    try {
                        //注册数据驱动
                        Class.forName("com.mysql.jdbc.Driver");
                        //获取数据库连接
                        Connection conn = DriverManager.getConnection(
                                "jdbc:mysql://192.168.31.23:3306/test", "root",
                                "1236");
                        //创建statement
                        Statement stmt = conn.createStatement();
                        //执行查询

                        ResultSet rs = stmt.executeQuery("select * from data");

                        int intPageSize; //一页显示的记录数
                        int intRowCount; //记录的总数
                        int intPageCount; //总页数
                        int intPage; //待显示的页码
                       String strPage;
                        int i;
                        //设置一页显示的记录数
                        intPageSize = 3;
                        //取得待显示的页码
                        strPage = request.getParameter("pageq");/*<a href='cp1.jsp?pageq=" + j + "'>" + j + "</a>");*/
                        //当strpage==1
                        //判断strPage是否等于null,如果是，显示第一页数据
                        if (strPage == null) {
                            intPage = 1;
                        } else {
                            //将字符串转换为整型
                            intPage = java.lang.Integer.parseInt(strPage);
                            /*待显示的页码     strPage为字符型变量*/
                            out.println("strPage的值"+strPage+"\n"+intPage);
                        
                        }
                        if (intPage < 1) {
                        /*当页数小于1时*/
                            intPage = 1;
                        }
                        //获取记录总数
                      rs.last();//移到最后一行
                        out.println(rs.last());
                        intRowCount = rs.getRow();//当前有一共有多少条数据
                        
                          out.println("当前数据"+rs.getRow());
                      
                        intPageCount = (intRowCount+intPageSize-1)/ intPageSize;  //计算总页数   8 +3-1/3
                           out.println("\r总页数"+intPageCount ); 
                        //调整待显示的页码
                        if (intPage > intPageCount)//当待显示页数大于总页数
                            intPage = intPageCount;
                        if (intPageCount > 0) {
                            //将记录指针定位到待显示页的第一条记录上
                            rs.absolute((intPage - 1) * intPageSize + 1);//2-1*3+1允许你指定结果集的绝对位置,
                            out.println(rs.absolute((intPage - 1) * intPageSize + 1)+"会出错吗");
                        }
                        //下面用于显示数据
                        i = 0;
                        while (i<intPageSize&&!rs.isAfterLast()) {//rs.isAfterLast()表征已到达结果集的结尾
                %>

                <tr>
                    <td class="cptdleft"><img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1520776595119&di=5c880feb79c72e52ebc761ec687f1f40&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01b9bd574c5bbc6ac72525ae97b9f5.jpg" width="50px" height="30px"></td>
                    <td class="cptdmiddle">
                   <a href="page.jsp?i=<%=rs.getString(1)%>" target="_blank"></a><br></td>
                  <a href=""><%=rs.getString(2)%></a>  
                    <td class="cptdright">2015-06-20</td>

                </tr>
                <%
                    rs.next();
                            i++;
                        }
                        //关闭连接、释放资源
                        rs.close();
                        stmt.close();
                        conn.close();
                %>
                <tr>
                    <td colspan="2" align="center">共<span class="bluefont"><%=intRowCount%></span>个记录，分<span
                        class="bluefont"><%=intPageCount%></span>页显示，当前页是：第<span
                        class="bluefont"><%=intPage%></span>页 <span class="bluefont">
                            <%

                                for (int j = 1; j<= intPageCount; j++) {
                                        out.print("&nbsp;&nbsp;<a href='page.jsp?pageq=" + j + "'>" + "页码"+j+/*显示页码*/ "</a>");
            					
                                    }
                            
                                   
                            %>
                    </span> 
 
 <%
     } catch (Exception e) {
         e.printStackTrace();
     }
 %>
                    </td>
                </tr>

            </table>

        </div>

       
    </div>
</body>
</html>