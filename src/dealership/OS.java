package dealership;

import java.sql.Connection;
import dealership.DAO.CarDAO;
import dealership.DAO.ClientDAO;
import dealership.DAO.EmployeeDAO;
import dealership.DAO.LoggingUtil;
import dealership.util.ConnectionFactory;

public class OS {

	public static void main(String[] args) {
	Connection cn = ConnectionFactory.getConnection();
	LoggingUtil.trace();
		
//		EmployeeDAO ed = new EmployeeDAO();
//		Employee ne = new Employee(11, "Blake", "Substitute", "trainer@revature.com", "1234");
//		ed.addEmployee(ne);
		
//		ClientDAO cd = new ClientDAO();
//		Client c = new Client(3, "Tester", "Testington", "test@mail.com", "abc"); 
//		cd.addClient(c);
			
		Homescreen homescreen = new Homescreen();

	}
}
