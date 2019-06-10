package dealership;

import java.util.Scanner;

public class ClientScreen  {
	Inventory inventory;
	Client client;
	
	public ClientScreen(Inventory inv, Client user) {
		inventory = inv;
		client = user;
		System.out.println("Hello, " + user.getUsername() + " you have logged into Lloyd Cars Portal!");
		ClientMenu();
	}
	
	public void ClientMenu() {
		System.out.println("What would you like to do next?");
		System.out.println("1. View cars currently in the lot.\n"
							+ "2. Make an offer on a viewed car.\n"
							+ "3. View my owned cars.\n"
							+ "4. View my car payments.\n"
							+ "5. Logout.");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		
		switch(choice) {
		case 1: 
			inventory.mainLot.viewCarList();
			ClientMenu();
			break;
		case 2: 
			inventory.mainLot.viewCarList();
			System.out.println("Which car would you like to buy?\n");
			scan = new Scanner(System.in);
			int a = scan.nextInt();
			scan = new Scanner(System.in);
			
			System.out.println("How much would you like to bid?\n");
			double b = scan.nextDouble();
			client.makeOffer(b);
			inventory.mainLot.getCar().get(a -1).getOffer().put(client, b);
			ClientMenu();
			break;
		case 3:
			System.out.println("Checking for owned cars...");
			client.viewOwnedCars();
			ClientMenu();
			break;
		case 4:
			System.out.println("Checking for car payments...");
			client.viewCarPayments();
			ClientMenu();
			break;
		case 5:
			System.out.println("Logging out...");
			Homescreen homescreen = new Homescreen(inventory);
			break;
		}
	}

}