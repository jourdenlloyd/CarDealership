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
		Homescreen homescreen = new Homescreen();

	}
}
