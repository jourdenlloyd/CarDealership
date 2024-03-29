package dealership.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dealership.Client;
import dealership.inter.ClientPermissions;
import dealership.util.ConnectionFactory;

public class ClientDAO implements ClientPermissions
	{
	public static Connection conn = ConnectionFactory.getConnection();

	public void clientLogin(String us)
		{

			
			String sql = "SELECT username FROM \"Project 0\".client where username = " + "'" + us
					+ "'";
			Statement stmt;

			try
				{
					stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);

					while (rs.next())
						{
							System.out.println("You have logged in!\n");
						}

				} catch (SQLException e1)
				{
					LoggingUtil.warn("The username or password is not valid.\n");
					e1.printStackTrace();
				}
		}
	
		public void addClient(Client c)
		{
			int id = c.getClientid();
			String fn = c.getFirstname();
			String ln = c.getLastname();
			String us = c.getUsername();
			String pass = c.getPassword();

			String sql = "INSERT INTO \"Project 0\".client (clientid, firstname, lastname, username, password) VALUES(?,?,?,?,?)";
			PreparedStatement stmt;

			try
				{
					stmt = conn.prepareStatement(sql);
					stmt.setInt(1, id);
					stmt.setString(2, fn);
					stmt.setString(3, ln);
					stmt.setString(4, us);
					stmt.setString(5, pass);
					stmt.executeUpdate();
				} catch (SQLException e)
				{
					LoggingUtil.info("SQL exception in addClient method.");
					e.printStackTrace();
				}
		}

	@Override
	public void makeOffer(double i, double j, double pr)
		{
			PreparedStatement stmt;
			String sql = "INSERT INTO \"Project 0\".payments (clientid, carid, offer, status)"
					+ "VALUES(?, ?, ?, 'Pending');";

			try
				{
					stmt = conn.prepareStatement(sql);
					stmt.setDouble(1, i);
					stmt.setDouble(2, j);
					stmt.setDouble(3, pr);
					stmt.executeUpdate();
					System.out.println("Your offer has been made.\n");

				} catch (SQLException e)
				{
					LoggingUtil.info("SQL exception in makeOffer method.");
					e.printStackTrace();
				}
		}

	@Override
	public void viewOwnedCars(int i)
		{
//TODO figure out how to realign this
			String sql = "SELECT car.carid, car.make, car.model, car.\"year\" FROM \"Project 0\".car inner join \"Project 0\".payments on car.carid = payments.carid where payments.clientid = "
					+ i;
			PreparedStatement st;

			try
				{
					st = conn.prepareStatement(sql);
					ResultSet rs = st.executeQuery();

					if (rs.next() == false)
						{
							System.out.println("You have no cars.\n");
						}
					while (rs.next())
						{
							System.out.println("CarID\t" + "Make\t" + "Model\t" + "Year");
							System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
									+ rs.getString(3) + "\t" + rs.getString(4));

						}
				} catch (SQLException e)
				{
					LoggingUtil.info("SQL exception in viewOwnedCars method.");
					e.printStackTrace();
				}
		}

	@Override
	public void viewCarPayments(int i)
		{
			PreparedStatement stmt;
			String sql = "select car.make, car.model, payments.offer, payments.payment from \"Project 0\".car inner join \"Project 0\".payments on car.carid = payments.carid where payments.clientid ="
					+ i;

			try
				{
					stmt = conn.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();

					if (rs.next() == false)
						{
							System.out.println("You have no payments.\n");
						}

					while (rs.next())
						{
							System.out.println("Car" + "\t" + "\t" + "Offer" + "\t" + "Payment");
							System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t"
									+ rs.getInt(3) + "\t" + rs.getInt(4));
						}

				} catch (SQLException e)
				{
					LoggingUtil.info("SQL exception in viewCarPayments method.");
					e.printStackTrace();
				}
		}
	}
