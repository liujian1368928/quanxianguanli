package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import entity.Delete;
import entity.add;
import entity.change;
import entity.jiaosecheck;
import entity.yonghuguanli;
public class yonghuadd_update_delete_dao extends Basedao {
	Connection conn=this.openconn();
	PreparedStatement st;
	String sql=null;
	String res=null;
	public String Deletedata(yonghuguanli sj) {
		// TODO Auto-generated method stub
		String res;
		try{
		sql="delete from yonghu where yonghuid='"+sj.getYonghuid()+"'"; /*单词写错*///'"+sj.getName()+"','"+sj.getYear()+"'
		st=conn.prepareStatement(sql);
		st.execute(sql);
		res="删除成功";
		conn.close();	
		}catch(Exception ex){
			res="删除失败";
		}
		return res;
	}
	public String updatedata(yonghuguanli sj) {
		// TODO Auto-generated method stub
		try{
		sql="update yonghu set  yonghumingcheng='"+sj.getYonghumingcheng()+"',yonghumima='"+sj.getYonghumima()+"',jid='"+sj.getJid()+"' where yonghuid="+sj.getYonghuid(); /*单词写错*///'"+sj.getName()+"','"+sj.getYear()+"'
		st=conn.prepareStatement(sql);
		st.executeUpdate();
		res="修改成功";
		conn.close();	
		}catch(Exception ex){
			res="修改失败";
		}
		return res;
	}
	public String adddata(yonghuguanli yhadd) {
		// TODO Auto-generated method stub	
		try{
		sql="insert into yonghu (yonghumingcheng,yonghumima,jid) values('"+yhadd.getYonghumingcheng()+"','"+yhadd.getYonghumima()+"','"+yhadd.getJid()+"') ";/*单词写错*/
		st=conn.prepareStatement(sql);
		st.execute();
		res="添加成功";
		conn.close();	
		}catch(Exception ex){
			res="添加失败";
		}
		return res;
	}

}
