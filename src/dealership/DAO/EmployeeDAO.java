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

	@Override
	public void acceptOffers(int i, int j) {
		//does this count as a stored procedure since it does two statements?
		
		String sql = "update \"Project 0\".payments set status = 'Accepted' where carid = ? and clientid = ?;";
		PreparedStatement stmt;
		String sql2 = "update \"Project 0\".payments set payment = (offer/12) where status = 'Accepted';";
		PreparedStatement stmt2;
				
		//TODO possibly add the stored procedure here so that we can reject offers for the same car when one is accepted
		// String sql3 = "update \"Project 0\".payments set status = 'Rejected' where carid = ? and not clientid = ?;"
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, i);
			stmt.setInt(2, j);
			stmt.executeUpdate();
			stmt2 = conn.prepareStatement(sql2);
			stmt2.executeUpdate();
			
			/*
			 * stmt3 = conn.prepareStatement(sql3);   stmt.setInt(1, i); stmt.setInt(2, j);
			 * stmt.executeUpdate();
			 */
			
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
		String sql = "SELECT clientid, carid, offer, payment, approverid, status FROM \"Project 0\".payments;";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4) + "\t"
						+ rs.getInt(5) + "\t" + rs.getString(6));
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
			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
			}

		} catch (SQLException ex) {
			LoggingUtil.info("SQL exception in viewAllCustomers method.");
			ex.printStackTrace();
		}
	}
}
