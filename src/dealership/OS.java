package dealership;

import java.sql.Connection;
import dealership.DAO.CarDAO;
import dealership.DAO.ClientDAO;
import dealership.util.ConnectionFactory;

public class OS {

	public static void main(String[] args) {

		Connection cn = ConnectionFactory.getConnection();
		
//		CarDAO cd=new CarDAO();
//		cd.addCar(new Car(2, "bmw", "xyw", "2019"));
		/*
		 * ClientDAO cc = new ClientDAO(); cc.viewCarPayments(1);
		 */
		
		//EmployeeDAO ed = new EmployeeDAO();
		//ed.addEmployee(new Employee(1, "Jourden", "Lloyd", "jourden@revcars.com", "123"));
		
		Homescreen homescreen = new Homescreen();
		
		
		
	}
}
