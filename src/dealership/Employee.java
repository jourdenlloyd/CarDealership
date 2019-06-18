package dealership;

import dealership.inter.EmployeePermissions;

public class Employee implements EmployeePermissions {
	// fields
	private int employeeid;
	private String firstname;
	private String lastname;
	private String username = "";
	private String password = "";

	// args constructor
	public Employee(int employeeid, String firstname, String lastname, String username, String password) {
		this.employeeid = employeeid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	// no args constructor
	public Employee() {
		super();
	}

	public Employee(String us, String pass) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void acceptOffers(int i, int j) {

	}

	@Override
	public void rejectOffers(int i, int j) {

	}

	@Override
	public void viewAllPayments() {

	}

	@Override
	public void viewAllCustomers() {

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
