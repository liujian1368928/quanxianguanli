package manager;

import dao.quanxianbiaodao;
import entity.quanxianliebiao;
public class quanxianmanager{
	
		public String saveqxb(String jsid, String[] checkbox){
			String quanxianliebiao="";
			for(String s:checkbox){
				System.out.println(s);
				quanxianliebiao=quanxianliebiao+","+s;//在每个数字之间==之间加上逗号
			}
			if(quanxianliebiao.substring(0,1).equals(",")){
				quanxianliebiao=quanxianliebiao.substring(1);//截取第一个逗号
				quanxianliebiao="("+quanxianliebiao+")";//把截取后的数组加上括号
				System.out.println("-"+quanxianliebiao+"-");
			}
			quanxianbiaodao qxdao=new quanxianbiaodao();
			String res=qxdao.saveqxb(jsid,quanxianliebiao);
			return res;
	}
}