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
			String sql="select * from ��Ʒ���";
			try{
				PreparedStatement st=conn.prepareStatement(sql);
				ResultSet rs=st.executeQuery();
				while(rs.next()){
					xiaolie xl=new xiaolie();
					xl.setPaixu(rs.getInt("����"));
					xl.setSjid(rs.getInt("�ϼ�ID"));
					xl.setXlbeizhu(rs.getString("��ע"));
					xl.setXlid(rs.getInt("���ID"));
					xl.setXlmingcheng(rs.getString("�������"));
					list.add(xl);
				}
			}catch(Exception e){
				
			}
			
			return list;
			
			
		}
}
