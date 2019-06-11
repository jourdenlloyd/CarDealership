package dealership;

import java.io.Serializable;
import java.util.Scanner;

import dealership.DAO.LoggingUtil;
import dealership.inter.Login;

public class Homescreen implements Serializable {
	Inventory inventory = new Inventory();
	
	public Homescreen(Inventory currentInventory) {
		LoggingUtil.trace("Start of program.\n\n");
		
		inventory = currentInventory;
		System.out.println("___ Welcome to Lloyd Cars! ___\n");
		System.out.println("Please login to continue. " + "Press 1");
		System.out.println("Need to sign up? " + "Press 2");
		System.out.println("Ready to logout? " + "Press 3");
			
		boolean checker = true;
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			
		while (checker) {
			switch (choice) {
			case 1: 
				boolean valid = true;
				while (valid) {
				System.out.println("Are you an employee (E) or a client (C)?");
				scan = new Scanner(System.in);
				String loginType = scan.nextLine();
			if (loginType.equals("C") || loginType.equals("c") || (loginType.equals("E") || loginType.equals("e"))){
				scan = new Scanner(System.in);
				System.out.println("Please enter your username and password.");
				scan = new Scanner(System.in);
				String username = scan.next();
				scan = new Scanner(System.in);
				String password = scan.nextLine();
				Login(inventory, username, password, loginType); 
					checker = false;
					valid = false;
			} else {
				valid = true;
			}
				} 
					break;
			case 2: 
				boolean valid1 = true;
				while (valid1) {
				System.out.println("Are you a new employee (E) or a new client (C)?");
				scan = new Scanner(System.in);
				String userType = scan.nextLine();
				if (userType.equals("C") || userType.equals("c") || (userType.equals("E") || userType.equals("e"))){
				scan = new Scanner(System.in);
				System.out.println("Please create a username and password.");
				scan = new Scanner(System.in);
				String name = scan.next();
				scan = new Scanner(System.in);
				String pass = scan.nextLine();
				CreateAccount(inventory, name, pass, userType);
				} else {
					valid1 = true;
				}
					} 
					break;
			case 3:
				System.out.println("Exiting...");
				OS.dao.saveInventory(inventory);
				
				System.exit(0);
					break;
					default: System.out.println("Please enter 1-3.");
					checker = true;
					break;
			}
		}
	}

	private void CreateAccount(Inventory inventory2, String username, String password, String userType) {
		if (userType.equals("E") || userType.equals("e")) {
			Employee employee = new Employee(username, password, inventory2);
			inventory2.eList.add(employee);
			EmployeeScreen eScreen = new EmployeeScreen(inventory2, employee);
		} else if (userType.equals("C") || userType.equals("c")){
			Client client = new Client(username, password);
			inventory2.cList.add(client);
			ClientScreen cScreen = new ClientScreen(inventory2, client);
		}
		
	}

	private void Login(Inventory inventory2, String username, String password, String loginType) {
		if (loginType.equals("E") || loginType.equals("e")) {
			if (inventory2.geteList().isEmpty()) {
				System.out.println("Login not found! Please create an account.\n\n\n");
				Homescreen homescreen = new Homescreen(inventory2);
			} else {
				for (int i = 0; i < inventory2.eList.size(); i++) {
				if (inventory2.geteList().get(i).getUsername().equals(username) && inventory2.geteList().get(i).getPassword().equals(password)) {
					EmployeeScreen eScreen = new EmployeeScreen(inventory2, inventory.geteList().get(i));
				} else {
					System.out.println("Sorry, this account was not found. Please try again or create a new account.");
					Homescreen homescreen = new Homescreen(inventory2);
				}
			}
		}
			
		} else if (loginType.equals("C") || loginType.equals("c")) {
			if (inventory2.getcList().isEmpty()) {
				System.out.println("Welcome to Lloyd Cars! Please create an account.");
				Login(inventory2, username, password, loginType);
			} else {
				for (int i = 0; i < inventory2.cList.size(); i++) {
					if (inventory2.getcList().get(i).getUsername().equals(username) && inventory2.getcList().get(i).getPassword().equals(password)) {
						ClientScreen cScreen = new ClientScreen(inventory2, inventory2.getcList().get(i));
					} else {
						System.out.println("Sorry, this account was not found. Please try again or create a new account.");
						Login(inventory2, username, password, loginType);
					}
				}
			}
			
		}
	}

}
