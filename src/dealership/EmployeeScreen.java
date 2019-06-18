package dealership;

import java.util.Scanner;
import dealership.DAO.CarDAO;
import dealership.inter.ClientPermissions;

public class EmployeeScreen {
	
	Employee employee;
	public static CarDAO c = new CarDAO();

	public EmployeeScreen(Employee emp) {
		
		employee = emp;
		System.out.println("Hello, " + employee.getUsername() + " you have logged into Lloyd Cars Portal!\n\n");
		EmployeeMenu();
	}

	public void EmployeeMenu() {
		System.out.println("___ Welcome to Lloyd Cars Employee Portal! ___\n");
		System.out.println("What would you like to do next?");
		System.out.println("1. View cars currently in the lot.\n" + "2. Add a car to the lot.\n"
				+ "3. Remove a car from the lot.\n" + "4. Accept offers for cars in the lot.\n"
				+ "5. Reject offers for cars in the lot.\n" + "6. View incoming car payments.\n" + "7. Logout.\n\n\n");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();

		switch (choice) {
		case 1:
			c.getAllCars();
			EmployeeMenu();
			break;
		case 2:
			System.out.println("Which car would you like to add?");
			System.out.println("Enter the carID, make, model, & year.");
			
			int carID = scan.nextInt();
			scan = new Scanner(System.in);
			String make = scan.nextLine();
			scan = new Scanner(System.in);
			String model = scan.nextLine();
			scan = new Scanner(System.in);
			String year = scan.nextLine();
			scan = new Scanner(System.in); 
			
			c.addCar(new Car(carID, make, model, year));
			System.out.println("Thanks for adding a car!\n\n");
			EmployeeMenu();
			break;
		case 3:
			c.getAllCars();
			System.out.println("Which car would you like to remove? Please enter the number of that item.");
			int oldCar = scan.nextInt();
			c.removeCar(oldCar);
			System.out.println("The car " + oldCar + " has been removed.\n\n");
			EmployeeMenu();
			break;
		case 4:
			System.out.println("For which car would you like to accept offers?");
			//add the new method here
			System.out.println("Please choose a car.\n");
			int acceptedCar = scan.nextInt();
			int clientID = 1;
			//add the new method here
			
			System.out.println("Please choose a client.\n");
			int clientI = scan.nextInt();
			//fix these methods
			
			EmployeeMenu();
			break;
		case 5:
			System.out.println("For which car would you like to reject offers?");
			//new method here
			System.out.println("Please choose a car.\n");
			int rejectedCar = scan.nextInt();
			int clientId = 1;
			//new method here
			
			System.out.println("The offer has been rejected.\n");
			EmployeeMenu();
			break;
		case 6:
			System.out.println("Looking up payments...\n");
			//new method here

			EmployeeMenu();
			break;
		case 7:
			System.out.println("Thank you for using Lloyd Cars Portal!\n");
			System.out.println("Logging out...\n\n\n");
			Homescreen homescreen = new Homescreen();
			break;
		}
	}

}
