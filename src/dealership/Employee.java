package dealership;

import java.io.Serializable;
import java.util.List;

import dealership.inter.EmployeePermissions;

public class Employee implements EmployeePermissions, Serializable {
//create a lot then go into it with the methods below
	private String username = "";
	private String password = "";
	private Inventory inv;
	
	

	public Employee(String username2, String password2, Inventory inventory) {
		username = username2;
		password = password2;
		inv = inventory;
	}

	@Override
	public void addCar(Car car) {
		inv.mainLot.addCar(car);
		
	}

	@Override
	public void removeCar(Car car) {
		inv.mainLot.removeCar(car);
		
	}

	@Override
	public double acceptOffers(Car car, double offer, Client client) {
		inv.mainLot.addPurchasedCar(car, offer, client);
		return offer;
	}

	@Override
	public double rejectOffers(Car car, double offer, Client client) {
		inv.mainLot.viewCarLedger().get(car.getMake() + car.getModel()).remove(client);
		return offer;
	}

	@Override
	public void viewAllPayments() {
		int i = 0;
		if (inv.getcList().isEmpty()) {
			System.out.println("You currently have no payments.");
		}
		else { 
			for (Client c : inv.getcList()) {
			System.out.println(c.getUsername());
			c.viewCarPayments();
			}	
		} 
	}

	@Override
	public void viewCarInfo(Car make, Car model) {
		inv.mainLot.viewCarList().get(0).getMake();
		inv.mainLot.viewCarList().get(0).getModel();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
