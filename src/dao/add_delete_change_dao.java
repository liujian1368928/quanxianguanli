package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Delete;
import entity.add;
import entity.check;
import entity.change;

public class add_delete_change_dao {
	Connection conn;
	PreparedStatement st;
	String sql=null;
	String res=null;
	
	public String Deletedata(Delete sj) {
		// TODO Auto-generated method stub
		String res;
		try{
		Class.forName("com.mysql.jdbc.Driver");/*单词漏写*/
		conn=DriverManager.getConnection("jdbc:mysql://192.168.31.23:3306/test","root","1236");
		sql="delete from ceshi where id='"+sj.getId()+"'"; /*单词写错*///'"+sj.getName()+"','"+sj.getYear()+"'
		st=conn.prepareStatement(sql);
		st.execute(sql);
		res="删除成功";
		conn.close();	
		}catch(Exception ex){
			res="删除失败";
		}
		return res;
	}
	public String updatedata(change sj) {
		// TODO Auto-generated method stub
		try{
		Class.forName("com.mysql.jdbc.Driver");/*单词漏写*/
		conn=DriverManager.getConnection("jdbc:mysql://192.168.31.23:3306/test","root","1236");
		sql="update ceshi set  supplier='"+sj.getSupplier()+"',goods='"+sj.getGoods()+"',price='"+sj.getPrice()+"',date='"+sj.getDate()+"',shuoming='"+sj.getShuoming()+"'where id="+sj.getId(); /*单词写错*///'"+sj.getName()+"','"+sj.getYear()+"'
		st=conn.prepareStatement(sql);
		st.executeUpdate(sql);
		res="修改成功";
		conn.close();	
		}catch(Exception ex){
			res="修改失败";
		}
		return res;
	}
	public String adddata(add sj) {
		// TODO Auto-generated method stub	
		try{
		Class.forName("com.mysql.jdbc.Driver");/*单词漏写*/
		conn=DriverManager.getConnection("jdbc:mysql://192.168.31.23:3306/test","root","1236");
		sql="insert into ceshi (supplier,goods,price,date,shuoming) values('"+sj.getSupplier()+"','"+sj.getGoods()+"','"+sj.getPrice()+"','"+sj.getDate()+"','"+sj.getShuoming()+"')";/*单词写错*/
		st=conn.prepareStatement(sql);
		st.execute(sql);
		res="添加成功";
		conn.close();	
		}catch(Exception ex){
			res="添加失败";
		}
		return res;
	}
}
