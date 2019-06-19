package dealership;

import java.util.Scanner;

import dealership.DAO.ClientDAO;
import dealership.DAO.EmployeeDAO;
import dealership.DAO.LoggingUtil;

public class Homescreen {
	public static EmployeeDAO ed = new EmployeeDAO();
	public static ClientDAO cd = new ClientDAO();

	public Homescreen() {
		LoggingUtil.trace();

		System.out.println("___ Welcome to Lloyd's 3D Cars! ___\n");
		System.out.println("1. " + "Please login to continue. ");
		System.out.println("2. " + "Need to sign up? ");
		System.out.println("3. " + "Ready to exit? ");

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
					if (loginType.equals("E") || loginType.equals("e")) {
						scan = new Scanner(System.in);
						System.out.println("Please enter your username and password.");
						scan = new Scanner(System.in);
						String us = scan.next();
						scan = new Scanner(System.in);
						String pass = scan.nextLine();
						
						ed.employeeLogin(us);
						EmployeeScreen employeescreen = new EmployeeScreen();
						//valid = false;
					} else if (loginType.equals("C") || loginType.equals("c")) {
						scan = new Scanner(System.in);
						System.out.println("Please enter your username and password.");
						scan = new Scanner(System.in);
						String us = scan.next();
						scan = new Scanner(System.in);
						String pass = scan.nextLine();
						
						cd.clientLogin(us);
						ClientScreen clientscreen = new ClientScreen();
					}
				}
				break;
			case 2:
				boolean valid1 = true;
				while (valid1) {
					System.out.println("Are you a new employee (E) or a new client (C)?");
					scan = new Scanner(System.in);
					String userType = scan.nextLine();
					if ((userType.equals("E") || userType.equals("e"))) {
						System.out.println("Please enter your employeeID.");
						int id = scan.nextInt();
						scan = new Scanner(System.in);
						System.out.println("Please enter your first and last name.");
						String fn = scan.nextLine();
						scan = new Scanner(System.in);
						String ln = scan.nextLine();
						System.out.println("Please create a username and password.");
						scan = new Scanner(System.in);
						String us = scan.next();
						scan = new Scanner(System.in);
						String pass = scan.nextLine();

						Employee ne = new Employee(id, fn, ln, us, pass);
						ed.addEmployee(ne);
						Homescreen homescreen = new Homescreen();
					} else {
						if ((userType.equals("C") || userType.equals("c"))) {
							System.out.println("Please enter your customerID.");
							int id = scan.nextInt();
							scan = new Scanner(System.in);
							System.out.println("Please enter your first and last name.");
							String fn = scan.nextLine();
							scan = new Scanner(System.in);
							String ln = scan.nextLine();
							System.out.println("Please create a username and password.");
							scan = new Scanner(System.in);
							String us = scan.next();
							scan = new Scanner(System.in);
							String pass = scan.nextLine();

							Client c = new Client(id, fn, ln, us, pass);
							cd.addClient(c);
							System.out.println("Client account created.\n\n");
							Homescreen homescreen = new Homescreen();
						}
						else {
							valid = true;
					}
					break;
				}
			}		
			case 3:
				System.out.println("Exiting...");
				System.out.println("You have exited the program...\n\n\n");
				System.exit(0);
				LoggingUtil.trace();
				break;
			default:
				System.out.println("Please enter 1-3.");
				checker = false;
				Homescreen homescreen = new Homescreen();
				break;
			}
		}
		System.out.println("\n\n");
	}

}
