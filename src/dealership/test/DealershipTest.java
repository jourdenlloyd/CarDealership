package dealership.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dealership.DAO.LoggingUtil;

class DealershipTest {
	public static DealershipTestDriver d = new DealershipTestDriver();

	private static DealershipTest dealershiptest;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    public void testGetAllCars() {
        
        assertEquals(true, d.getAllCars());  
    }
	
	@Test
    public void testIsEmployee() {
        
        assertEquals(true, d.ifIsAnEmp(1));  
    }
    @Test
    public void testIsAccepted() {

        assertEquals(true, d.acceptTestOffer(1));  
    }
    @Test
    public void testIsEmployeelogin() {
        
        assertEquals(true, d.employeeLogin("jourden@revcars.com"));
    }
    
    @Test
    public void testIsClientlogin() {
        
        assertEquals(true, d.clientLogin("testclient@gmail.com"));    
    }
    

}
