package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Search;
import entity.check;


public class checkdao {

	public ArrayList<check> getdata() {
		// TODO Auto-generated method stub
		ArrayList<check> li=new ArrayList<check>();
		try{
		Class.forName("com.mysql.jdbc.Driver");/*单词漏写*/
		Connection conn=DriverManager.getConnection("jdbc:mysql://192.168.31.23:3306/test","root","1236");
		String sql="select * from ceshi";/*单词写错*/
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{	int id=rs.getInt("id");
			String supplier=rs.getString("supplier");
			String goods=rs.getString("goods");
			int price=rs.getInt("price");
			String date=rs.getString("date");
			String shuoming=rs.getString("shuoming");
			check kh=new check();
			kh.setId(id);
			kh.setSupplier(supplier);
			kh.setGoods(goods);
			kh.setPrice(price);
			kh.setDate(date);
			kh.setShuoming(shuoming);
			li.add(kh);
		}
		conn.close();	
		}catch(Exception ex){
			System.out.println("错误");
		}
		return li;	
	}


	public ArrayList<check> search(check search) {
		// TODO Auto-generated method stub
		ArrayList<check> li=new ArrayList<check>();
		try{
		Class.forName("com.mysql.jdbc.Driver");/*单词漏写*/
		Connection conn=DriverManager.getConnection("jdbc:mysql://192.168.31.23:3306/test","root","1236");
		String sql="SELECT * FROM ceshi WHERE (supplier LIKE '%"+search.getSearch()+"%' or goods LIKE '%"+search.getSearch()+"%' "+
				"or price LIKE '%"+search.getSearch()+"%'or date LIKE '%"+search.getSearch()+"%' or shuoming LIKE '%"+search.getSearch()+"%')";/*单词写错*/
		//OR price LIKE '"+sear.getSearch()+"' OR date LIKE '"+sear.getSearch()+"'
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				/*若购如果直接用方法的search，会导致数据覆盖*/
				 check sear=new check();
				 sear.setSupplier(rs.getString("supplier"));
				 sear.setGoods(rs.getString("goods"));
				 sear.setPrice(rs.getInt("price"));
				 sear.setDate(rs.getString("date"));
				 sear.setShuoming(rs.getString("shuoming"));
				li.add(sear);
			}	
		conn.close();	
		}catch(Exception ex){
			System.out.println("错误");
		}
		return li;	
	}

}
