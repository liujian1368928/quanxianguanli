package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entity.menu;
import entity.subMenu;

public class menudao extends Basedao{
		public ArrayList<menu> getmenu(String id){
			Connection conn=this.openconn();
			Statement st=null;
			String sql;
			ArrayList<menu> menulist=new ArrayList<menu>();
			try{
		    sql="SELECT * FROM `v_xitongquanxian` WHERE jsid="+id;/*单词写错*/
			st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			menu me=null;
			while(rs.next()){
				
				String xid=rs.getString("jsqxid");
				String xtmingcheng=rs.getString("xtmingcheng");
				String url=rs.getString("url");
				int shangjiid=rs.getInt("shangjiid");
				//String beizhu=rs.getString("beizhu");
				int liulan=rs.getInt("liulan");
				int xtqxid=rs.getInt("xtqxid");
				//如果当前记录的shangjiid==0，说明这是一个顶层菜单	
				if(shangjiid==0){
					me=new menu();
					me.setXtmingcheng(xtmingcheng);	
					me.setUrl(url);
					me.setLiulan(liulan);
					me.setXid(Integer.valueOf(xid) );	
					me.setXtqxid(xtqxid);
					menulist.add(me);
				}				
				if(shangjiid!=0){
					subMenu sbmenu=new subMenu();
					sbmenu.setXtmingcheng(xtmingcheng);
					sbmenu.setUrl(url);
					sbmenu.setShangjiid(shangjiid);
					sbmenu.setJsqxit(Integer.valueOf(xid));	
					sbmenu.setLiulan(liulan);
					me.getSubMenu().add(sbmenu);
				}					
			   }
			}catch(Exception ex){	
				System.out.println(ex.getMessage());
			}finally{
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}	
			return menulist;
		}	
}
