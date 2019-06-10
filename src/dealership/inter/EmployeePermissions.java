package dealership.inter;

import java.util.List;

import dealership.Car;
import dealership.Client;

public interface EmployeePermissions {
	//seralizable

	public double acceptOffers(Car car, double offer, Client client);
	public void addCar(Car car);
	public void removeCar(Car car);
	public double rejectOffers(Car car, double offer, Client client);
	public void viewAllPayments();
	public void viewCarInfo(Car make, Car model);
	
	
}
