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
		//2018/10/18 �� �������Ҫ���ȰѴ����(lbid)��С��id��(sjid)�ҳ������棬Ȼ��֮��Աȴ������id���ϼ�id���Ա������࣬����ǾͰ�С��ŵ�����
		int cnt=xllist.size();	
		for(int i=0;i<cnt;i++){
			xiaolie xl=xllist.get(i);//System.out.println(xllist.get(i).getPaixu());
			
			if(xl.getSjid()==0){
				dalie dl=new dalie();
				dl.setBeizhu(xl.getXlbeizhu());
				dl.setLbid(xl.getXlid());//С��id
				dl.setLbmingcheng(xl.getXlmingcheng());
				dl.setSjid(0);				
				hmlist.put(String.valueOf(dl.getLbid()), dl);//��1,2,3�����ϼ�id=0�����id������������д��map����			
			//System.out.println("String.valueOf"+String.valueOf(dl.getLbid()));
			//System.out.println("dl"+dl.getLbmingcheng()+"id"+dl.getSjid());
			}			
		}		
		//System.out.println("��ΰ�ƽ���С�༯�ϣ�ת��Ϊ�����������С�༯��  �ļ���");
		for(int i=0;i<cnt;i++){
			xiaolie xiaolei=xllist.get(i);
			//System.out.println(i);
			String key=String.valueOf(xiaolei.getSjid());//С����ϼ�id(���е����id)
			System.out.println(key);//������ע��
			if(hmlist.containsKey(key)==true){//���map������ļ����ϼ�id����0�����id����С��id����ϼ�id��ͬ	
				//�Ͱ�С��ŵ����Ӧ�Ĵ�����
				//System.out.println("hmlist.containsKey��ֵΪ"+hmlist.containsKey(key));
				hmlist.get(key).getXiaolie().add(xiaolei);//�ŵ�key������
			}					
		}
		dllist=new ArrayList<dalie>(hmlist.values());//hmlist.values()����Ϊ1��2��3
		return dllist;
	}

		
	}
//	System.out.println("key��ֵΪ"+key);
//System.out.println(key+"key��ֵΪ");
//System.out.println(hmlist.containsKey(String.valueOf(i))==true);
//System.out.println("--------");

/*	Set a=hmlist.keySet();//��ȡ���ļ���
Iterator it=a.iterator();
while(it.hasNext()){
	Object key2=it.next();
	Object value=hmlist.get(key2);
	System.out.println(key2+":"+value);
}*/
