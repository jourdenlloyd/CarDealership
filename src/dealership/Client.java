package dealership;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dealership.inter.ClientPermissions;

public class Client implements ClientPermissions, Serializable {
	private String username = "";
	private String password = "";
	
	
	private ArrayList<Double> myOffers = new ArrayList<Double>();
	private ArrayList<Car> myOwnedCars = new ArrayList<Car>();
	private Map<Car, ArrayList<Double>> myPayments = new HashMap<Car, ArrayList<Double>>(); 
	
	public Client(String name, String pass) {
		username = name;
		password = pass;
	} 
	
	public void viewOffers()
	{
		for (Double a : myOffers) {
			System.out.println(myOffers);
		}
	}

	@Override
	public void makeOffer(double i) {
		myOffers.add(i);
	}

	@Override
	public void viewOwnedCars() {
		if (myOwnedCars.isEmpty()) {
			System.out.println("You currently do not own any cars.");
		} else {
		for (Car a : myOwnedCars) {
			System.out.println(a.getMake() + " " + a.getModel());
		} 
			}
	}

	public void myNewCar(Car car) {
		myOwnedCars.add(car);
	}
	
	public void carPayment(Car car, double offer) {
		ArrayList<Double> cp = new ArrayList<Double>();
		for (int i = 0; i < 13; i++) {
			cp.add((offer/12));
		}
		myPayments.put(car, cp);
	}
	
	@Override
	public void viewCarPayments() {
		for (Car a : myOwnedCars) {
			System.out.println(myPayments.get(a));
			if (myPayments.isEmpty()) {
				System.out.println("You currently have no payments.");
			}
		}
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	

}
