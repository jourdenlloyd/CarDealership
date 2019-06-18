package dealership.DAO;

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

public class EmployeeDAO implements EmployeePermissions {

	public static Connection conn = ConnectionFactory.getConnection();

	public void addEmployee(Employee e) {

		int id = e.getEmployeeid();
		String fn = e.getFirstname();
		String ln = e.getLastname();
		String us = e.getUsername();
		String pass = e.getPassword();

		String sql = "INSERT INTO \"Project 0\".employee (employeeid, firstname, lastname, username, password) VALUES(?,?,?,?,?)";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, fn);
			stmt.setString(3, ln);
			stmt.setString(4, us);
			stmt.setString(5, pass);
			stmt.executeUpdate();
		} catch (SQLException ex) {

			ex.printStackTrace();
		}
	}

	@Override
	public void acceptOffers(int i, int j) {
		
		String sql = "update \"Project 0\".payments set status = 'Accepted' where carid = " + i + "and clientid = " + j;
		PreparedStatement stmt;
//		String sql2 = "update \"Project 0\".payments set payment = (offer/12) where status = 'Accepted';";
//		PreparedStatement stmt2;
				
		try {
			stmt = conn.prepareStatement(sql);
			//stmt2 = conn.prepareStatement(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void rejectOffers(int i, int j) {
		String sql = "update payments set status = 'Rejected' where carid =" + i + "and clientid =" + j;
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
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

			ex.printStackTrace();
		}
	}
}
