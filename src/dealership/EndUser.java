package dealership;

import java.io.Serializable;
import java.util.ArrayList;

public class EndUser implements Serializable {

	ArrayList<Employee> eList = new ArrayList<>();
	ArrayList<Client> cList = new ArrayList<>();
	
	public ArrayList<Employee> geteList() {
		return eList;
	}
	public void seteList(ArrayList<Employee> eList) {
		this.eList = eList;
	}
	public ArrayList<Client> getcList() {
		return cList;
	}
	public void setcList(ArrayList<Client> cList) {
		this.cList = cList;
	}
}
