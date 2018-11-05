package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.quanxianbiao;
import entity.quanxianliebiao;


public class quanxianbiaodao extends Basedao{

	public ArrayList<quanxianbiao> getqxb(quanxianbiao jsid) {	
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		ArrayList<quanxianbiao> qxblist=new ArrayList<quanxianbiao>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?characterEncoding=UTF-8","root","1236");//jdbc:odbc:fd-sqlserver
			String sql="SELECT * FROM `v_xitongquanxian` WHERE jsid="+jsid.getJsid();
			st=conn.prepareStatement(sql);
			rs=st.executeQuery();
			quanxianbiao qxb=null;
		
			while(rs.next()){				
				int shangjiid=rs.getInt("shangjiid");
				if(shangjiid==0){
					 qxb=new quanxianbiao();
					 qxb.setJsid(rs.getInt("jsid"));
					qxb.setShangjiid(rs.getInt("shangjiid"));
					qxb.setXtqxid(rs.getInt("xtqxid"));
					qxb.setXtmingcheng(rs.getString("xtmingcheng"));
					qxblist.add(qxb);
					}
				if(rs.getInt("shangjiid")!=0){
					quanxianliebiao	qxsz=new quanxianliebiao();
					qxsz.setJsid(Integer.valueOf(qxb.getJsid()));
					qxsz.setJsqxid(rs.getInt("jsqxid"));
					qxsz.setLiulan(rs.getInt("liulan"));
					qxsz.setXtqxid(rs.getInt("xtqxid"));
					qxsz.setShangjiid(rs.getInt("shangjiid"));
					qxsz.setXtmingcheng(rs.getString("xtmingcheng"));
					qxb.getQxlblist().add(qxsz);
					}
			}
		}catch(Exception ex)
		{
			
		}finally
		{
			//this.closeConn(conn, st, rs);
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return qxblist;
	}	
	
	public String saveqxb(String jsid, String quanxianliebiao){
		
		String res = null;
		Connection conn=this.openconn();
		PreparedStatement st=null;
		try {
			conn.setAutoCommit(false);//为手动提交到数据库
			//conn=DriverManager.getConnection("jdbc:mysql://192.168.31.23:3306/demo?characterEncoding=UTF-8","root","1236");//jdbc:odbc:fd-sqlserver
			//通过jsid来将权限属修改为0。获取jsqxid将权限修改为1，也还可以用系统权限id
			String sql1="UPDATE `jiaosequanxiansheding` SET liulan=0 WHERE jsid="+jsid;//当前jsid为多少他的liulan的值为0
			String sql2="UPDATE `jiaosequanxiansheding` SET liulan=1 WHERE jsqxid IN "+quanxianliebiao;//in后面代指范围内多少修改成1
			st=conn.prepareStatement(sql1);
			st.executeUpdate();
			st=conn.prepareStatement(sql2);
			st.executeUpdate();
			conn.commit();//提交
			res="成功";
		}catch (SQLException e) {
			res="失败";
			try {
				conn.rollback();//回滚
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			this.closeConn(conn, st);	
		}
		return res;
	}
}
