package dealership;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Car implements Serializable {
	private String make;
	private String model;
	
	private Map<Client ,Double> offers = new HashMap<>();
	
	public Car(String make, String model) {
		super();
		this.make = make;
		this.model = model;
		
	}


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
		return offers ;
	}


	public void setOffer(Client client, double offer) {
		this.offers.put(client , offer);
	}

}
