package dealership;

import java.util.Scanner;

public class EmployeeScreen {
	Inventory inventory;
	Employee employee;
	
	public EmployeeScreen(Inventory inv, Employee emp) {
		inventory = inv;
		employee = emp;
		System.out.println("Hello, " + employee.getUsername() + " you have logged into Lloyd Cars Portal!\n\n");
		EmployeeMenu();
	}
	
	public void EmployeeMenu() {
		System.out.println("What would you like to do next?");
		System.out.println("1. View cars currently in the lot.\n"
							+ "2. Add a car to the lot.\n"
							+ "3. Remove a car from the lot.\n"
							+ "4. Accept offers for cars in the lot.\n"
							+ "5. Reject offers for cars in the lot.\n"
							+ "6. View incoming car payments.\n"
							+ "7. Logout.");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		
		switch(choice) {
		case 1: 
			inventory.mainLot.viewCarList();
			EmployeeMenu();
			break;
		case 2: 
			System.out.println("Which car would you like to add?");
			System.out.println("Enter the make: ");
			String make = scan.nextLine();
			System.out.println("Enter the model: ");
			Scanner scan1 = new Scanner(System.in);
			String model = scan1.nextLine();
			inventory.mainLot.addCar(new Car (make, model));
			System.out.println("Thanks for adding a car!");
			EmployeeMenu();
			break;
		case 3:
			inventory.mainLot.viewCarList();
			System.out.println("Which car would you like to remove? Please enter the number of that item.");
			int oldCar = scan.nextInt();
			inventory.mainLot.removeCar(inventory.mainLot.getCar().get(oldCar - 1));
			System.out.println("The car " + oldCar + " has been removed.");
			EmployeeMenu();
			break;
		case 4:
			inventory.mainLot.viewCarList();
			System.out.println("For which car would you like to accept offers?");
			int acceptedCar = scan.nextInt();
			int clientID = 1;
			Car car = inventory.mainLot.getCar().get(acceptedCar - 1);
				for (Client c : car.getOffer().keySet()) {
					System.out.println(clientID + " " + c.getUsername());
					clientID++;
				}
				int clientI = scan.nextInt();
				Client client = (Client) car.getOffer().keySet().toArray()[clientI - 1];
				double currentCar = car.getOffer().get(client);
				employee.acceptOffers(car, currentCar, client);
			EmployeeMenu();
			break;
		case 5:
			System.out.println("For which car would you like to reject offers?");
			int rejectedCar = scan.nextInt();
			int clientId = 1;
			Car car1 = inventory.mainLot.getCar().get(rejectedCar - 1);
				for (Client c : car1.getOffer().keySet()) {
					System.out.println(clientId + " " + c.getUsername());
					clientId++;
				}
				int client1 = scan.nextInt();
				Client currentClient = (Client) car1.getOffer().keySet().toArray()[client1 - 1];
				double currentCar1 = car1.getOffer().get(currentClient);
				employee.rejectOffers(car1, currentCar1, currentClient);
			EmployeeMenu();
			break;
		case 6:
			System.out.println("Looking up payments...");
			
			EmployeeMenu();
			break;
		case 7:
			System.out.println("Logging out...");
			Homescreen homescreen = new Homescreen(inventory);
			break;
		}
	}
	
}
