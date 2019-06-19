package dealership.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import dealership.Car;
import dealership.inter.CarServices;
import dealership.util.ConnectionFactory;

public class CarDAO implements CarServices {

	public static Connection conn = ConnectionFactory.getConnection();

	@Override
	public void addCar(Car c) {
		int i = c.getCarID();
		String s1 = c.getMake();
		String s2 = c.getModel();
		String d = c.getYear();

		PreparedStatement stmt;
		String sql = "insert into \"Project 0\".car" + "(carid, make, model, year)" + " values (?, ?, ?, ?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, i);
			stmt.setString(2, s1);
			stmt.setString(3, s2);
			stmt.setString(4, d);
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeCar(int i) {
		String sql = "DELETE FROM \"Project 0\".car WHERE carid = ?;";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, i);
			stmt.execute();
			System.out.println("The car has been removed.\n");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getAllCars() {

		String sql = "select * from \"Project 0\".car order by carid asc";
		Statement stmt;

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("CarID" + "\t" + "Make" + "\t" + "Model" + "\t" + "Year");

			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4));
			}

		} catch (SQLException e) {
			System.out.println("Query failed.");
			e.printStackTrace();
		}

	}

	public void updateCar(int i, int j) {
		//String sql = "UPDATE \"Project 0\".payments SET approverid = ? WHERE carid = ?;" ;

	}

}
