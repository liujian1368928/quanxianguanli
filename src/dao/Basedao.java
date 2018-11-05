package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Basedao {
	public Connection openconn(){	
		Connection conn=null;
		try{
			// 第一步：加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//第二步：打开连接
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?characterEncoding=UTF-8","root","1236");//jdbc:odbc:fd-sqlserver
		}catch(Exception ex){
			//写入异常日志中
			System.out.println("出错了！error："+ex.getMessage());			
		}	
		return conn;
	}
	public void closeConn(Connection conn,Statement st){
		try {
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void closeConn(Connection conn,Statement st,ResultSet  rs){
		try {
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
