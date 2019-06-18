package dealership;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dealership.inter.ClientPermissions;

public class Client implements ClientPermissions {
	//no args constructor
	public Client() {
		super();
	}
	
	//fields
	private int clientid;
	private String firstname;
	private String lastname;
	private String username = "";
	private String password = "";
	
	//args constructor
	public Client(int clientid, String firstname, String lastname, String username, String password) {
		super();
		this.clientid = clientid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	//getters and setters
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getClientid() {
		return clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
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

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	//abstract methods
	@Override
	public void viewOwnedCars(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewCarPayments(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeOffer(double i, double j, double pr) {
		// TODO Auto-generated method stub
		
	}

}
