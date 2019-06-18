package dealership;

import java.util.Scanner;

import dealership.DAO.EmployeeDAO;
import dealership.DAO.LoggingUtil;

public class Homescreen {
	public static EmployeeDAO ed = new EmployeeDAO();
	
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
					if (loginType.equals("C") || loginType.equals("c")
							|| (loginType.equals("E") || loginType.equals("e"))) {
						scan = new Scanner(System.in);
						System.out.println("Please enter your username and password.");
						scan = new Scanner(System.in);
						String username = scan.next();
						scan = new Scanner(System.in);
						String password = scan.nextLine();
				// TODO fix the login method
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
					if ((userType.equals("E") || userType.equals("e"))) {
						System.out.println("Please enter your first and last name.");
						String fn = scan.nextLine();
						scan = new Scanner(System.in);
						String ln = scan.nextLine();
						System.out.println("Please create a username and password.");
						scan = new Scanner(System.in);
						String us = scan.next();
						scan = new Scanner(System.in);
						String pass = scan.nextLine();
					//TODO id can't be empty
					//	Employee ne = new Employee(0, fn, ln, us, pass);
					//	ed.addEmployee(ne);
					} else {
						valid1 = true;
					}
				}
				break;
			case 3:
				System.out.println("Exiting...");
			// TODO check to see if saving is still necessary?
				System.out.println("You have exited the program...\n\n\n");
				System.exit(0);
				LoggingUtil.trace();
				break;
			default:
				System.out.println("Please enter 1-3.");
				checker = true;
				break;
			}
		}
	}

}
