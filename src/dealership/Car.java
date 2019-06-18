package dealership;

import java.util.HashMap;
import java.util.Map;

public class Car {
	private int carID;
	private String make;
	private String model;
	private String year;

	//args constructor
	public Car(int carID, String make, String model, String year) {
		this.carID = carID;
		this.make = make;
		this.model = model;
		this.year = year;

	}
	
	//no args constructor
	public Car () {
		
	}
	
	//getters and setters
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
