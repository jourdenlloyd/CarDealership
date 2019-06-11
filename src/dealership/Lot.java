package dealership;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dealership.Car;

public class Lot implements Serializable {
	//list of cars in the lot, by make & model
	private static List<Car> CarList = new ArrayList<>();
	//list of cars on the lot that have an offer (key is car make & model, value is offer for the car)
	private static Map<String, Map<Client, Double>> CarLedger = new HashMap<String, Map<Client, Double>>();
	//list of cars that have been purchased (cars removed from the carlist and the carledger once sold)
	private static Map<String, Double> PurchasedCars = new HashMap<String, Double>();
	
	
	public void addCar(Car car) {
		Lot.CarList.add(car);
	}
	
	public List<Car> getCar() {
		return CarList;
	}
	public List<Car> viewCarList() {
		if (CarList.isEmpty()) {
			System.out.println("The lot is currently empty. Please add a car. \n");
		}
		int carNum = 1;
		for (Car a : CarList) {
			System.out.println(carNum + " " + a.getMake() + " " + a.getModel());
			carNum++;
		}
		return CarList;
	}
	
	public void addCar(String carInfo, Map<Client, Double> offer) {
		CarLedger.put(carInfo, offer);
	}
	
	public Map<String, Map<Client, Double>> viewCarLedger(){
		return CarLedger;
	}
	
	public Map<String, Double> viewPurchasedCars(){
		return PurchasedCars;
	}
	
	public void addPurchasedCar(Car car, double offer, Client client) {
		PurchasedCars.put((car.getMake() + car.getModel()), offer);	
		Lot.CarList.remove(car);
		CarLedger.remove(car.getMake() + car.getModel());
		client.myNewCar(car);
		client.carPayment(car, offer);
	}

	public void removeCar(Car car) {
		Lot.CarList.remove(car);	
	}
	
	

}
