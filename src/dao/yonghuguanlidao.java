package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entity.yonghuguanli;
import entity.jiaosequanxian;

public class yonghuguanlidao extends Basedao{
	public ArrayList<yonghuguanli> getyhgl(int pageno,int pagesize){
		Connection conn =conn=this.openconn();
		// TODO Auto-generated method stub
		ArrayList<yonghuguanli> list=new ArrayList<yonghuguanli>();
		
		String sql="select * from v_yonghujiaose limit "+(pageno-1)*pagesize+","+pagesize;/*单词写错*/
		try{	
		
			//String sql="select * from jiaose limit "+(pageno-1)*pagesize+","+pagesize;/*单词写错*/
			PreparedStatement st=conn.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
				while(rs.next()){
					yonghuguanli yhgl=new yonghuguanli();
					yhgl.setJid(rs.getInt("jid"));		
					yhgl.setYonghuid(rs.getInt("yonghuid"));
					yhgl.setYonghumingcheng(rs.getString("yonghumingcheng"));
					yhgl.setYonghumima(rs.getString("yonghumima"));
					yhgl.setJiaosemingcheng(rs.getString("jiaosemingcheng"));
					list.add(yhgl);
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
