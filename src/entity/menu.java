package entity;

import java.util.ArrayList;
public class menu {
	private int liulan;
	private int xtqxid;
	private int xid;
	private String xtmingcheng;
	private String beizhu;
	private int shangjiid;
	private String url;
	private int orderid;
	public int getLiulan() {
		return liulan;
	}
	public void setLiulan(int liulan) {
		this.liulan = liulan;
	}
	public int getXtqxid() {
		return xtqxid;
	}
	public void setXtqxid(int xtqxid) {
		this.xtqxid = xtqxid;
	}
	public int getXid() {
		return xid;
	}
	public void setXid(int xid) {
		this.xid = xid;
	}
	public String getXtmingcheng() {
		return xtmingcheng;
	}
	public void setXtmingcheng(String xtmingcheng) {
		this.xtmingcheng = xtmingcheng;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public int getShangjiid() {
		return shangjiid;
	}
	public void setShangjiid(int shangjiid) {
		this.shangjiid = shangjiid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	private ArrayList<subMenu> subMenu=new ArrayList<subMenu>();
   public ArrayList<subMenu> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(ArrayList<subMenu> subMenu) {
		this.subMenu = subMenu;
	}


}
