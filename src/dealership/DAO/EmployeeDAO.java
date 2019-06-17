package dealership.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dealership.Car;
import dealership.Client;
import dealership.Employee;
import dealership.inter.EmployeePermissions;
import dealership.util.ConnectionFactory;

public class EmployeeDAO implements EmployeePermissions {
	public static Connection conn = ConnectionFactory.getConnection();

	public void addEmployee(Employee e) {
	    
        int id = e.getEmployeeid(); String fn = e.getFirstname(); String ln = e.getLastname() ; String us = e.getUsername(); String pass = e.getPassword();
        
        String sql="INSERT INTO \"Project 0\".employee (employeeid, firstname, lastname, username, password) VALUES(?,?,?,?,?)";
        PreparedStatement stmt;
        
        try {
            stmt=conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2,fn);
            stmt.setString(3,ln);
            stmt.setString(4, us);
            stmt.setString(5, pass);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
            
    }

	@Override
	public double acceptOffers(Car car, double offer, Client client) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double rejectOffers(Car car, double offer, Client client) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void viewAllPayments() {
		// TODO Auto-generated method stub
		
	}
	
}
