package dealership.inter;

import java.util.List;

import dealership.Car;
import dealership.Client;

public interface EmployeePermissions {

	public double acceptOffers(Car car, double offer, Client client);

	public double rejectOffers(Car car, double offer, Client client);

	public void viewAllPayments();


}
