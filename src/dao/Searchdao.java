package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entity.jiaoseguanli;
import entity.yonghuguanli;

public class Searchdao extends Basedao{
	public ArrayList<jiaoseguanli> search(jiaoseguanli search) {
	
		// TODO Auto-generated method stub
		ArrayList<jiaoseguanli> li=new ArrayList<jiaoseguanli>();
		Connection conn=this.openconn();
		PreparedStatement st=null;
		ResultSet rs=null;
		String sql="SELECT * FROM jiaose WHERE (jiaosemingcheng LIKE '%"+search.getJiaosemingcheng()+"%' or beizhu LIKE '%"+search.getJiaosemingcheng()+"%')";/*单词写错*/
		try{
		st=conn.prepareStatement(sql);
		rs=st.executeQuery();
		while(rs.next()){
				//若购如果直接用方法的search，会导致数据覆盖
			jiaoseguanli sear=new jiaoseguanli();
				sear.setJiaosemingcheng(rs.getString("jiaosemingcheng"));
				sear.setBeizhu(rs.getString("beizhu"));
				li.add(sear);
			}	
		}catch(Exception ex){
			System.out.println("错误");
		}finally{
			this.closeConn(conn, st, rs);
		}
		return li;	
	}
	public ArrayList<yonghuguanli> search(yonghuguanli search) {
		
		// TODO Auto-generated method stub
		ArrayList<yonghuguanli> li=new ArrayList<yonghuguanli>();
		Connection conn=this.openconn();
		PreparedStatement st=null;
		ResultSet rs=null;
		String sql="SELECT * FROM v_yonghujiaose WHERE (yonghumingcheng LIKE '%"+search.getYonghumingcheng()+"%' or yonghumima LIKE '%"+search.getYonghumingcheng()+"%' or jiaosemingcheng like '%"+search.getYonghumingcheng()+"%')";/*单词写错*/
		try{
		st=conn.prepareStatement(sql);
		rs=st.executeQuery();
		while(rs.next()){
				//若购如果直接用方法的search，会导致数据覆盖
			yonghuguanli sear=new yonghuguanli();
			sear.setYonghumingcheng(rs.getString("yonghumingcheng"));
			sear.setYonghumima(rs.getString("yonghumima"));
			sear.setJiaosemingcheng(rs.getString("jiaosemingcheng"));
			li.add(sear);
			}	
		}catch(Exception ex){
			System.out.println("错误");
		}finally{
			this.closeConn(conn, st, rs);
		}
		return li;	
	}
}
