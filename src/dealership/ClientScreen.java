package dealership;

import java.util.Scanner;

import dealership.DAO.CarDAO;
import dealership.DAO.ClientDAO;

public class ClientScreen {
	
	Client client;
	public static CarDAO c = new CarDAO();
	public static ClientDAO cd = new ClientDAO();

	public ClientScreen(Client user) {
		client = user;
		System.out.println("Hello, " + user.getUsername() + " you have logged into Lloyd Cars Portal!\n");
		ClientMenu();
	}

	public ClientScreen() {
	}

	public void ClientMenu() {
		System.out.println("___ Welcome to Lloyd Cars Client Portal! ___\n");
		System.out.println("What would you like to do next?");
		System.out.println("1. View cars currently in the lot.\n" + "2. Make an offer on a viewed car.\n"
				+ "3. View my owned cars.\n" + "4. View my car payments.\n" + "5. Logout.");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();

		switch (choice) {
		case 1:
			c.getAllCars();
			ClientMenu();
			break;
		case 2:
			c.getAllCars();
			System.out.println("Which car would you like to buy?\n");
			scan = new Scanner(System.in);
			int a = scan.nextInt();
			scan = new Scanner(System.in);

			System.out.println("How much would you like to bid?\n");
			double b = scan.nextDouble();
			cd.makeOffer(b, b, b);
			//TODO 
			ClientMenu();
			break;
		case 3:
			System.out.println("To see your current cars, please enter your clientID number.");
			int i = scan.nextInt();
			System.out.println("Checking for owned cars...\n");
			cd.viewOwnedCars(i);
			ClientMenu();
			break;
		case 4:
			System.out.println("Checking for car payments...");
			//client.viewCarPayments();
			ClientMenu();
			break;
		case 5:
			System.out.println("Thank you for using Lloyd Cars Portal!\n");
			System.out.println("Logging out...\n\n\n");
			Homescreen homescreen = new Homescreen();
			break;
		}
	}

}
