package entity;

import java.util.ArrayList;

public class dalie {
	private int lbid;
	private String lbmingcheng;
	private String beizhu;
	private int sjid;
	private int paixu;
private ArrayList<xiaolie> xiaolie=new ArrayList<xiaolie>();

	public int getLbid() {
	return lbid;
}

public void setLbid(int lbid) {
	this.lbid = lbid;
}

public String getLbmingcheng() {
	return lbmingcheng;
}

public void setLbmingcheng(String lbmingcheng) {
	this.lbmingcheng = lbmingcheng;
}

public String getBeizhu() {
	return beizhu;
}

public void setBeizhu(String beizhu) {
	this.beizhu = beizhu;
}

public int getSjid() {
	return sjid;
}

public void setSjid(int sjid) {
	this.sjid = sjid;
}

public int getPaixu() {
	return paixu;
}

public void setPaixu(int paixu) {
	this.paixu = paixu;
}

	public ArrayList<xiaolie> getXiaolie() {
		return xiaolie;
	}

	public void setXiaolie(ArrayList<xiaolie> xiaolie) {
		this.xiaolie = xiaolie;
	}

}
