package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.jiaosecheck;
import entity.jiaosequanxian;

public class jiaosecheckdao {
	public ArrayList<jiaosecheck> getyhJiaoSe(){
		Connection conn = null;
		// TODO Auto-generated method stub
		ArrayList<jiaosecheck> list=new ArrayList<jiaosecheck>();
		try{
//			Class.forName("com.mysql.jdbc.Driver");/*单词漏写*/
//			conn=DriverManager.getConnection("jdbc:mysql://192.168.31.23:3306/test","root","1236");
//			String sql="select * from jiaose"; /*单词写错*///'"+sj.getName()+"','"+sj.getYear()+"'
//			PreparedStatement st=conn.prepareStatement(sql);
//			ResultSet rs=st.executeQuery();
			
			Class.forName("com.mysql.jdbc.Driver");/*单词漏写*/
			conn=DriverManager.getConnection("jdbc:mysql://192.168.31.23:3306/demo","root","1236");
			String sql="select * from jiaose";/*单词写错*/
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
				while(rs.next()){
					jiaosecheck yhjs=new jiaosecheck();
					yhjs.setJid(rs.getInt("jid"));
					yhjs.setJiaosemingcheng(rs.getString("jiaosemingcheng"));
					yhjs.setBeizhu(rs.getString("beizhu"));
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
