package dealership;

import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable {
	EndUser endUser = new EndUser();
	Lot mainLot = new Lot();
	
	ArrayList<Employee> eList = endUser.geteList();
	ArrayList<Client> cList = endUser.getcList();
	
	
	public Lot getMainLot() {
		return mainLot;
	}
	public ArrayList<Employee> geteList() {
		return eList;
	}
	public ArrayList<Client> getcList() {
		return cList;
	}
}
