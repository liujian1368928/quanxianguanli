package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.xiaolie;

public class liebiaodao extends Basedao{
		public ArrayList<xiaolie> getliebiao(){
			ArrayList<xiaolie> list=new ArrayList<xiaolie>();
			Connection conn=this.openconn();
			String sql="select * from 商品类别";
			try{
				PreparedStatement st=conn.prepareStatement(sql);
				ResultSet rs=st.executeQuery();
				while(rs.next()){
					xiaolie xl=new xiaolie();
					xl.setPaixu(rs.getInt("排序"));
					xl.setSjid(rs.getInt("上级ID"));
					xl.setXlbeizhu(rs.getString("备注"));
					xl.setXlid(rs.getInt("类别ID"));
					xl.setXlmingcheng(rs.getString("类别名称"));
					list.add(xl);
				}
			}catch(Exception e){
				
			}
			
			return list;
			
			
		}
}
