package entity;

import java.util.ArrayList;

public class quanxianbiao {
	private int shangjiid;
	private int jsqxid;
	private int jsid;
	private int xtqxid;
	private String xtmingcheng;
	private ArrayList<quanxianliebiao> qxlblist=new ArrayList<quanxianliebiao>();
	
	public ArrayList<quanxianliebiao> getQxlblist() {
		return qxlblist;
	}
	public void setQxlblist(ArrayList<quanxianliebiao> qxlblist) {
		this.qxlblist = qxlblist;
	}
	public int getShangjiid() {
		return shangjiid;
	}
	public void setShangjiid(int shangjiid) {
		this.shangjiid = shangjiid;
	}
	public int getJsqxid() {
		return jsqxid;
	}
	public void setJsqxid(int jsqxid) {
		this.jsqxid = jsqxid;
	}
	public int getJsid() {
		return jsid;
	}
	public void setJsid(int jsid) {
		this.jsid = jsid;
	}
	public int getXtqxid() {
		return xtqxid;
	}
	public void setXtqxid(int xtqxid) {
		this.xtqxid = xtqxid;
	}
	public String getXtmingcheng() {
		return xtmingcheng;
	}
	public void setXtmingcheng(String xtmingcheng) {
		this.xtmingcheng = xtmingcheng;
	}

	
}
