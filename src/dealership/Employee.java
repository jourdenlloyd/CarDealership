package dealership;

import java.io.Serializable;
import java.util.List;

import dealership.inter.EmployeePermissions;

public class Employee implements EmployeePermissions{

	private int employeeid;
	private String firstname;
	private String lastname;
	private String username = "";
	private String password = "";
	
//args constructor
	public Employee(int employeeid, String firstname, String lastname, String username, String password) {
		this.employeeid = employeeid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}
	
//no args constructor
	public Employee() {
		super();
	}


	@Override
	public double acceptOffers(Car car, double offer, Client client) {
		//new method here
		System.out.println("The offer has been accepted");
		return offer;
	}

	@Override
	public double rejectOffers(Car car, double offer, Client client) {
		//new method here
		return offer;
	}

	@Override
	public void viewAllPayments() {
		//new method here
		int i = 0;
			System.out.println("You currently have no payments.");
		
	}

//Getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
