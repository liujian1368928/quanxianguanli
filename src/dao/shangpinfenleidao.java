package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.ajaxfenye;
import entity.shangpinquery;

public class shangpinfenleidao extends Basedao{
	public ArrayList<shangpinquery> getspfl(ajaxfenye sp){
		ArrayList<shangpinquery> list=new ArrayList<shangpinquery>();
		String sql1="";
		String sql2="";
		String limitstring="";
		String sql="select * from v_showallshangpin";
		int start=(sp.getPageno()-1)*sp.getPagesize();
		int end=sp.getPagesize();
		limitstring=" limit "+start+","+end;
		if(sp.getLeibeimingcheng().equals("all")){
			
		}else if(sp.getLeibeimingcheng().equals("C")){
			sql1="С��ID="+sp.getLeibeimingchengid();
		}else 	if(sp.getLeibeimingcheng().equals("F")){
			sql1="����ID="+sp.getLeibeimingchengid();
		}
		if(sp.getSearch().length()>0)//˵�������ж�����ִ������
		{
			sql2=" and Ʒ�� like'"+sp.getSearch()+"'";
		}
		if(sql1.length()>0){//���sql���Ȳ�����0
			sql=sql+" where "+sql1;
		}
		if(sql1.length()>0){
		if(sql.indexOf("where")==-1){
			System.out.println("�����ܳ���");
		}else{
			sql=sql+sql2;
		}
		}
		sql=sql+limitstring;
		Connection conn=null;
		PreparedStatement st=null;
	    ResultSet rs=null;
		try{
			 conn=this.openconn();
			 st=conn.prepareStatement(sql);
			 rs=st.executeQuery();
			while(rs.next()){
				shangpinquery SP=new shangpinquery();
				SP.setBeizhu(rs.getString("��ע"));
				SP.setDaleiid(rs.getInt("����ID"));
				SP.setDanwei(rs.getString("��λ"));
				SP.setGuige(rs.getString("���"));
				SP.setJiage(rs.getDouble("�۸�"));
				SP.setPingming(rs.getString("Ʒ��"));
				SP.setTiaoma(rs.getString("����"));
				SP.setXiaoleiid(rs.getInt("С��ID"));
				SP.setLeibiemingcheng(rs.getString("�������"));
				SP.setKucunliang(rs.getInt("�����"));
				list.add(SP);
				
			}
		}catch(Exception e){
			
		}finally{
			
			this.closeConn(conn, st, rs);
		}
		return list;
	}
	
	public int getpage(ajaxfenye sp){
		int page=0;
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		String sql="select count(*) as zongyeshu from v_showallshangpin";
		String sql2="";
		if(sp.getLeibeimingcheng().equals("F"))
		{
			sql2=" ����ID= "+sp.getLeibeimingchengid();
		}else if(sp.getLeibeimingcheng().equals("C"))
		{
			sql2=" С��ID= "+sp.getLeibeimingchengid();
		}
		if(sql2.length()>0){
			sql=sql+" where "+sql2;
		}
		
		try{
			conn=this.openconn();
		    st=conn.prepareStatement(sql);
			rs=st.executeQuery();
			
			while(rs.next()){
				int zongpage=rs.getInt("zongyeshu");
				if(zongpage%sp.getPagesize()==0){
					page=zongpage/sp.getPagesize();
				}else{
					page=zongpage/sp.getPagesize()+1;
				}
			}
		}catch(Exception x){
			
		}
		
		return page;
	}
}
