package dealership.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dealership.Car;
import dealership.Client;
import dealership.Employee;
import dealership.inter.EmployeePermissions;
import dealership.util.ConnectionFactory;
import dealership.DAO.LoggingUtil;

public class EmployeeDAO implements EmployeePermissions {

	public static Connection conn = ConnectionFactory.getConnection();
	
	public void employeeLogin(String us) {
		
		String sql = "SELECT username FROM \"Project 0\".employee where username = " + "'" + us + "'";
		Statement stmt;

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println("You have logged in!\n");
			}
			
		} catch (SQLException e1) {
			LoggingUtil.warn("The username or password is not valid.\n");
			e1.printStackTrace();
		}
		
	}
	
	public void addEmployee(Employee ne) {
		int id = ne.getEmployeeid();
		String fn = ne.getFirstname();
		String ln = ne.getLastname();
		String us = ne.getUsername();
		String pass = ne.getPassword();

		String sql = "INSERT INTO \"Project 0\".employee (employeeid, firstname, lastname, username, \"password\") VALUES(?, ?, ?, ?, ?);";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, fn);
			stmt.setString(3, ln);
			stmt.setString(4, us);
			stmt.setString(5, pass);
			stmt.executeUpdate();
			System.out.println("Employee account created.\n\n");

		} catch (SQLException ex) {
			LoggingUtil.info("SQL exception in addEmployee method.");
			ex.printStackTrace();
		}
	}

	public void viewCarsWithOffers() {
		String sql1 = "SELECT clientid, carid, offer, payment, status, offer_time FROM \"Project 0\".payments;";
		Statement stmt1;
		
		try {
			stmt1 = conn.createStatement();
			ResultSet rs = stmt1.executeQuery(sql1);
			System.out.println("ClId\t" + "CarId\t" + "Offer\t" + "Payment\t" + "Status\t" + "Offer Time");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6));
				
			} 
		}catch (SQLException e) {
			LoggingUtil.info();
			e.printStackTrace();
		}
	
	}
	
	@Override
	public void acceptOffers(int i, int j) {
	//Cannot get this to work so I am commenting it out in favor of an earlier statement, which starts a series of actions automated by this method and works similar to a more complicated stored procedure which might be able the MERGE keyword
		//String sql = "{call update_status(in ?, in ?)}";
		
		String sql = "update \"Project 0\".payments set status = 'Accepted' where carid = ? and clientid = ?;";
		PreparedStatement stmt;
		
		String sql2 = "update \"Project 0\".payments set payment = (offer/12) where status = 'Accepted';";
		PreparedStatement stmt2;
				
		String sql3 = "update \"Project 0\".payments set status = 'Rejected' where carid = ? and not clientid = ?;";
		PreparedStatement stmt3;
		
		try {
			/*
			 * CallableStatement call = conn.prepareCall(sql); call.setInt(1, i);
			 * call.setInt(2, j); int numberOfRows = call.executeUpdate();
			 * if(numberOfRows < 1) { conn.rollback();
			 * LoggingUtil.error("Not enough rows affected."); }
			 */
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, i); stmt.setInt(2, j);
			stmt.executeUpdate();
			System.out.println("The offer has been accepted!\n");
			
			stmt2 = conn.prepareStatement(sql2);
			stmt2.executeUpdate();
			System.out.println("The monthly payment has been updated!\n");
			
			stmt3 = conn.prepareStatement(sql3);   
			stmt3.setInt(1, i); stmt3.setInt(2, j);
			stmt3.executeUpdate();
			System.out.println("The other offers on the car have been rejected!\n");
			
		} catch (SQLException e) {
			LoggingUtil.info();
			e.printStackTrace();
		}
	}

	@Override
	public void rejectOffers(int i, int j) {
		String sql = "update \"Project 0\".payments set status = 'Rejected' where carid = ? and clientid = ?;";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, i);
			stmt.setInt(2, j);
			stmt.executeUpdate();
		} catch (SQLException e) {
			LoggingUtil.info("SQL exception in rejectOffers method.");
			e.printStackTrace();
		}
	}

	@Override
	public void viewAllPayments() {
		String sql = "SELECT clientid, carid, offer, payment, status FROM \"Project 0\".payments;";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			System.out.println("ClId\t" + "CarId\t" + "Offer\t" + "Payment\t" + "Status");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4) + "\t" + rs.getString(5));
			}

		} catch (SQLException ex) {
			LoggingUtil.info("SQL exception in viewAllPayments method.");
			ex.printStackTrace();
		}
	}

	@Override
	public void viewAllCustomers() {
		String sql = "SELECT clientid, firstname, lastname, username FROM \"Project 0\".client;";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			System.out.println("____________________Current Clients____________________");
			System.out.println("ClId\t" + "First Name\t\t" + "Last Name\t\t" + "Username");
			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t" + rs.getString(4));
			}

		} catch (SQLException ex) {
			LoggingUtil.info("SQL exception in viewAllCustomers method.");
			ex.printStackTrace();
		}
	}
}
