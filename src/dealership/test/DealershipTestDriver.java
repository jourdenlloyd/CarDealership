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

public boolean ifIsAnEmp(int user)
{
    
        String sql= "select * from  \"Project 0\".employee where employeeid = " + user;
    
    Statement stmt;
    int flag=0;
    try {
        stmt=conn.createStatement();        
        ResultSet rs =stmt.executeQuery(sql);

            if(rs.next())
                flag=1;
    
    } catch (SQLException e) {
        LoggingUtil.error(e.getMessage());
        e.printStackTrace();
    }
    
    if (flag==1)
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
	
}
