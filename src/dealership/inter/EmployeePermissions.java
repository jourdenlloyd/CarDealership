package dealership.inter;

import java.util.List;

import dealership.Car;
import dealership.Client;

public interface EmployeePermissions {

	public void acceptOffers(int i, int j);

	public void rejectOffers(int i, int j);

	public void viewAllPayments();
	
	public void viewAllCustomers();


}
