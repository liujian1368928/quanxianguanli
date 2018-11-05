package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.jiaosequanxian;

public class jiaosequanxiandao {

	public ArrayList<jiaosequanxian> getyhJiaoSe(){
		Connection conn = null;
		// TODO Auto-generated method stub
		ArrayList<jiaosequanxian> list=new ArrayList<jiaosequanxian>();
		try{
			Class.forName("com.mysql.jdbc.Driver");/*单词漏写*/
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","1236");
			String sql="select * from jiaose";/*单词写错*/
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
				while(rs.next()){
					jiaosequanxian yhjs=new jiaosequanxian();
					yhjs.setJid(rs.getInt("jid"));
					yhjs.setJiaosemingcheng(rs.getString("jiaosemingcheng"));
					list.add(yhjs);
				}
			}catch(Exception ex){
				
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		return list;
	}

}
