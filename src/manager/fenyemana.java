package manager;
import java.util.ArrayList;
import java.util.HashMap;
import dao.liebiaodao;
import entity.dalie;
import entity.xiaolie;

public class fenyemana {
	public ArrayList<dalie> fenyeman(){
		liebiaodao lb=new liebiaodao();
		ArrayList<dalie> dllist=new ArrayList<dalie>();
		ArrayList<xiaolie> xllist=lb.getliebiao();
		HashMap<String,dalie> hmlist=new HashMap<String,dalie>();
		//2018/10/18 这 里代码主要是先把大类的(lbid)和小类id的(sjid)找出来储存，然后之间对比大类类别id和上级id做对比来分类，如果是就把小类放到大类
		int cnt=xllist.size();	
		for(int i=0;i<cnt;i++){
			xiaolie xl=xllist.get(i);//System.out.println(xllist.get(i).getPaixu());
			
			if(xl.getSjid()==0){
				dalie dl=new dalie();
				dl.setBeizhu(xl.getXlbeizhu());
				dl.setLbid(xl.getXlid());//小类id
				dl.setLbmingcheng(xl.getXlmingcheng());
				dl.setSjid(0);				
				hmlist.put(String.valueOf(dl.getLbid()), dl);//（1,2,3）把上级id=0的类别id和其他的数据写入map集合			
			//System.out.println("String.valueOf"+String.valueOf(dl.getLbid()));
			//System.out.println("dl"+dl.getLbmingcheng()+"id"+dl.getSjid());
			}			
		}		
		//System.out.println("如何把平面的小类集合，转化为：大类里面带小类集合  的集合");
		for(int i=0;i<cnt;i++){
			xiaolie xiaolei=xllist.get(i);
			//System.out.println(i);
			String key=String.valueOf(xiaolei.getSjid());//小类的上级id(所有的类别id)
			System.out.println(key);//最先面注释
			if(hmlist.containsKey(key)==true){//如果map集合里的键（上级id等于0的类别id）和小类id里的上级id相同	
				//就把小类放到相对应的大类中
				//System.out.println("hmlist.containsKey的值为"+hmlist.containsKey(key));
				hmlist.get(key).getXiaolie().add(xiaolei);//放到key的下面
			}					
		}
		dllist=new ArrayList<dalie>(hmlist.values());//hmlist.values()里面为1，2，3
		return dllist;
	}

		
	}
//	System.out.println("key的值为"+key);
//System.out.println(key+"key的值为");
//System.out.println(hmlist.containsKey(String.valueOf(i))==true);
//System.out.println("--------");

/*	Set a=hmlist.keySet();//获取键的集合
Iterator it=a.iterator();
while(it.hasNext()){
	Object key2=it.next();
	Object value=hmlist.get(key2);
	System.out.println(key2+":"+value);
}*/
