package dealership.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dealership.Client;
import dealership.inter.ClientPermissions;
import dealership.util.ConnectionFactory;

public class ClientDAO implements ClientPermissions {
	public static Connection conn = ConnectionFactory.getConnection();
	
	public void addClient(Client c) {
	    
        int id = c.getClientid(); String fn = c.getFirstname();String ln = c.getLastname() ; String us = c.getUsername(); String pass = c.getPassword();
        
        String sql="INSERT INTO \"Project 0\".client (clientid, firstname, lastname, username, password) VALUES(?,?,?,?,?)";
        PreparedStatement stmt;
        
        try {
            stmt=conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2,fn);
            stmt.setString(3,ln);
            stmt.setString(4, us);
            stmt.setString(5, pass);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        
    }

	@Override
	public void makeOffer(double i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewOwnedCars(int i) {
	
		String sql= "SELECT carid, make, model, \"year\" FROM \"Project 0\".car where clientid =" + i;
		Statement st; 
		
		try {
			st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			if(rs.next()) System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void viewCarPayments() {
		// TODO Auto-generated method stub
		
	}
	
}
