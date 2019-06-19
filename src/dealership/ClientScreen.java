package dealership;

import java.util.Scanner;
import dealership.DAO.CarDAO;
import dealership.DAO.ClientDAO;
import dealership.DAO.LoggingUtil;

public class ClientScreen
	{

	Client client;
	public static CarDAO c = new CarDAO();
	public static ClientDAO cd = new ClientDAO();

	public ClientScreen() {
		System.out.println("___ Welcome to Lloyd Cars Client Portal! ___\n");
		ClientMenu();
	}

	public void ClientMenu()
		{
			LoggingUtil.trace();
			System.out.println("___ Lloyd Cars Client Portal ___\n");
			System.out.println("What would you like to do next?");
			System.out.println("1. View cars currently in the lot.\n"
					+ "2. Make an offer on a viewed car.\n" + "3. View my owned cars.\n"
					+ "4. View my car payments.\n" + "5. Logout.");

			boolean checker = true;
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			while (checker)
				{
					switch (choice)
					{
						case 1:
							System.out.println("____ Current Cars on the Lot ____");
							c.getAllCars();
							System.out.println("\n\n");
							ClientMenu();
							break;
						case 2:
							System.out.println("Which car would you like to buy?\n");
							c.getAllCars();
							System.out.println("Please enter your clientID number.\n");
							scan = new Scanner(System.in);
							double a = scan.nextInt();
							System.out.println("Please enter the desired carID number.\n");
							scan = new Scanner(System.in);
							double b = scan.nextDouble();
							System.out.println("How much would you like to bid?\n");
							double c = scan.nextDouble();
							cd.makeOffer(a, b, c);
							System.out.println("\n\n");
							ClientMenu();
							break;
						case 3:
							System.out.println(
									"To see your current cars, please enter your clientID number.");
							int i = scan.nextInt();
							System.out.println("Checking for owned cars...\n");
							cd.viewOwnedCars(i);
							System.out.println("\n\n");
							ClientMenu();
							break;
						case 4:
							System.out.println(
									"To see your current car payments, please enter your clientID number.");
							int j = scan.nextInt();
							System.out.println("Checking for car payments...");
							cd.viewCarPayments(j);
							System.out.println("\n\n");
							ClientMenu();
							break;
						case 5:
							System.out.println("Thank you for using Lloyd Cars Portal!\n");
							System.out.println("Logging out...\n\n\n");
							@SuppressWarnings(
								"unused"
							)
							Homescreen homescreen = new Homescreen();
							break;
						default:
							System.out.println("Please enter 1-5.");
							checker = true;
							break;
					}
				}
			System.out.println("\n");
		}
	}
