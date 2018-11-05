package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class querydatadao extends Basedao{
	public int getquerydata(int pagesize){
		int value=0;
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		String sql="select count(jid)as jid from jiaose";
		try{
			conn=this.openconn();
			st=conn.prepareStatement(sql);
			rs=st.executeQuery();
			while(rs.next())
			{
				int data=rs.getInt("jid");
				if(data%pagesize==0){
					value=data/pagesize;
				}else{
					value=data/pagesize+1;
				}
			}
			
		}catch(Exception e){
			
		}finally{
			
			this.closeConn(conn, st, rs);
		}
		return value;
	}
	public int getqueryyhdata(int pagesize){
		int value=0;
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		String sql="select count(yonghuid)as jid from v_yonghujiaose";
		try{
			conn=this.openconn();
			st=conn.prepareStatement(sql);
			rs=st.executeQuery();
			while(rs.next())
			{
				int data=rs.getInt("jid");
				if(data%pagesize==0){
					value=data/pagesize;
				}else{
					value=data/pagesize+1;
				}
			}
			
		}catch(Exception e){
			
		}finally{
			
			this.closeConn(conn, st, rs);
		}
		return value;
	}
}
