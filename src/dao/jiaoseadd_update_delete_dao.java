package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import entity.Delete;
import entity.add;
import entity.change;
import entity.jiaosecheck;
import entity.jiaoseguanli;

public class jiaoseadd_update_delete_dao extends Basedao{
	Connection conn=this.openconn();
	PreparedStatement st;
	String sql=null;
	String res=null;
	
	public String Deletedata(jiaoseguanli sj) {
		// TODO Auto-generated method stub
		String res;
		try{
		//Class.forName("com.mysql.jdbc.Driver");/*单词漏写*/
		//conn=DriverManager.getConnection("jdbc:mysql://192.168.31.23:3306/demo","root","1236");
		sql="delete from jiaose where jid='"+sj.getJid()+"'"; /*单词写错*///'"+sj.getName()+"','"+sj.getYear()+"'
		st=conn.prepareStatement(sql);
		st.execute(sql);
		res="删除成功";
		conn.close();	
		}catch(Exception ex){
			res="删除失败";
		}
		return res;
	}
	public String updatedata(jiaoseguanli sj) {
		// TODO Auto-generated method stub
		try{
		//Class.forName("com.mysql.jdbc.Driver");/*单词漏写*/
		//conn=DriverManager.getConnection("jdbc:mysql://192.168.31.23:3306/demo","root","1236");
		sql="update jiaose set  jiaosemingcheng='"+sj.getJiaosemingcheng()+"',beizhu='"+sj.getBeizhu()+"'where jid="+sj.getJid(); /*单词写错*///'"+sj.getName()+"','"+sj.getYear()+"'
		st=conn.prepareStatement(sql);
		st.executeUpdate(sql);
		res="修改成功";
		conn.close();	
		}catch(Exception ex){
			res="修改失败";
		}
		return res;
	}
	public String add(jiaoseguanli add) {
		// TODO Auto-generated method stub	
		try{
		//Class.forName("com.mysql.jdbc.Driver");/*单词漏写*/
		//conn=DriverManager.getConnection("jdbc:mysql://192.168.31.23:3306/demo","root","1236");
		sql="insert into jiaose (jiaosemingcheng,beizhu) values('"+add.getJiaosemingcheng()+"','"+add.getBeizhu()+"')";/*单词写错*/
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
