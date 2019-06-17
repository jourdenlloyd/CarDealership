package dealership;

import java.util.HashMap;
import java.util.Map;

public class Car {
	private int carID;
	private String make;
	private String model;
	private String year;
	

	private Map<Client, Double> offers = new HashMap<>();

	public Car(int carID, String make, String model, String year) {
		this.carID = carID;
		this.make = make;
		this.model = model;
		this.year = year;

	}

	public Car ()
	{}
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Map<Client, Double> getOffer() {
		return offers;
	}

	public void setOffer(Client client, double offer) {
		this.offers.put(client, offer);
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
