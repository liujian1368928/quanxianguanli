package manager;


import java.util.ArrayList;
import java.util.List;
import dao.checkdao;
import entity.check;



public class checkmanager {

	public List<check> getallkehu() {
		// TODO Auto-generated method stub
		checkdao dao=new checkdao();
		ArrayList<check> da=dao.getdata();
		return da;

	}

}
