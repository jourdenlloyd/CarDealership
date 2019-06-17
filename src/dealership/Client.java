package dealership;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dealership.inter.ClientPermissions;

public class Client implements ClientPermissions, Serializable {
	
	public Client() {
		super();
	}

	private int clientid;
	private String firstname;
	private String lastname;
	private String username = "";
	private String password = "";

	public Client(int clientid, String firstname, String lastname, String username, String password) {
		super();
		this.clientid = clientid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}
	
private ArrayList<Double> myOffers = new ArrayList<Double>();
	private ArrayList<Car> myOwnedCars = new ArrayList<Car>();
	private Map<Car, ArrayList<Double>> myPayments = new HashMap<Car, ArrayList<Double>>();


	public void viewOffers() {
		for (Double a : myOffers) {
			System.out.println(myOffers);
		}
	}

	@Override
	public void makeOffer(double i) {
		myOffers.add(i);
	}


	public void myNewCar(Car car) {
		myOwnedCars.add(car);
	}

	public void carPayment(Car car, double offer) {
		ArrayList<Double> cp = new ArrayList<Double>();
		for (int i = 0; i < 13; i++) {
			cp.add((offer / 12));
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

	public int getClientid() {
		return clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void viewOwnedCars(int i) {
		// TODO Auto-generated method stub
		
	}

}
