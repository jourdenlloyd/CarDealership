package dealership.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dealership.DAO.LoggingUtil;
import dealership.util.ConnectionFactory;

public class DealershipTestDriver {
public static Connection conn = ConnectionFactory.getConnection();

public boolean getAllCars() {

	String sql = "select * from \"Project 0\".car order by carid asc";
	Statement stmt;
	int flag = 0;

	try {
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("CarID" + "\t" + "Make" + "\t" + "Model" + "\t" + "Year");

		while (rs.next()) {
			System.out.println(
					rs.getInt(1) + " " + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4));
			flag = 1;
		}

	} catch (SQLException e) {
		System.out.println("Query failed.");
		e.printStackTrace();
	}
	if (flag == 1)
        return true ;
        else
            return false;

}

public boolean ifIsAnEmp(int user)
{
    
        String sql= "select * from  \"Project 0\".employee where employeeid = " + user;
    
    Statement stmt;
    int flag = 0;
    try {
        stmt=conn.createStatement();        
        ResultSet rs =stmt.executeQuery(sql);

            if(rs.next())
                flag = 1;
    
    } catch (SQLException e) {
        LoggingUtil.error(e.getMessage());
        e.printStackTrace();
    	}
    
    if (flag == 1)
        return true ;
        else
            return false;
	}

public boolean acceptTestOffer(int i) {
  
        String sql= "update \"Project 0\".payments set status = 'Accepted' where carid = " +i;
       
        PreparedStatement stmt;
        int flag=0;
       
        try {
            stmt= conn.prepareStatement(sql);
            stmt.executeUpdate();
            flag =1;
            
        } catch (SQLException e) {
            LoggingUtil.error(e.getMessage());
            e.printStackTrace();
        }
        
        if (flag==1)
            return true;
        else return false;
	}

public boolean employeeLogin(String us) {
	
	String sql = "SELECT username FROM \"Project 0\".employee where username = " + "'" + us + "'";
	Statement stmt;
	int flag = 0;

	try {
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			System.out.println("You have logged in!\n");
			flag = 2;
		}
		
	} catch (SQLException e1) {
		LoggingUtil.warn("The username or password is not valid.\n");
		e1.printStackTrace();
	}
	
		if(flag == 2) 
			return true;
		else return false;
		
		}

public boolean clientLogin(String us) {
	
	String sql = "SELECT username FROM \"Project 0\".client where username = " + "'" + us + "'";
	Statement stmt;
	int flag = 0;

	try {
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			System.out.println("You have logged in!\n");
			flag = 2;
		}
		
	} catch (SQLException e1) {
		LoggingUtil.warn("The username or password is not valid.\n");
		e1.printStackTrace();
	}
		if(flag == 2) 
		return true;
	else return false;
	
	}	
}


