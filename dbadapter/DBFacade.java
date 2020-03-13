package dbadapter;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import datatypes.PaymentData;
//import datatypes.RewardData;
import datatypes.StatusData;
import datatypes.SupporterData;
//import datatypes.StatusData;
import interfaces.IProject;


/**
 * Class which acts as the connector between application and database. Creates
 * Java objects from SQL returns. Exceptions thrown in this class will be
 * catched with a 500 error page.
 * 
 * @author Gr23
 *
 */
public class DBFacade implements IProject{
	private static DBFacade instance;
	
	

	/**
	 * Constructor which loads the corresponding driver for the chosen database
	 * type
	 */
	private DBFacade() {
		try {
			Class.forName("com." + Configuration.getType() + ".jdbc.Driver")
					.newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Implementation of the Singleton pattern.
	 * 
	 * @return
	 */
	public static DBFacade getInstance() {
		if (instance == null) {
			instance = new DBFacade();
			
		}

		return instance;
	}
	
	/**
	 * Function that returns all appropriate offers from the database.
	 * 
	 * @param pStatusSQL
	 *            compared with existing project's  Status.
	 * @return ArrayList of all offer objects.
	 * @throws SQLException 
	 */
	public ArrayList<Project> getProject(String pStatus) {
		ArrayList<Project> projects = new ArrayList<Project>();
		
			
		// Declare the necessary SQL queries.
		String sqlSelectP = "SELECT id,pName, pStatus FROM Project WHERE pStatus = ?";
		// Query all projects that fits to the given criteria.
		try (Connection connection = DriverManager.getConnection(
				"jdbc:" + Configuration.getType() + "://"
						+ Configuration.getServer() + ":"
						+ Configuration.getPort() + "/"
						+ Configuration.getDatabase(), Configuration.getUser(),
				Configuration.getPassword())) 
		{
			try (PreparedStatement  ps= connection.prepareStatement(sqlSelectP))
			{    
					ps.setString(1, pStatus);
				
				
			
				try	 (ResultSet res = ps.executeQuery()) {
					
					while (res.next()) {
						
						
	
						
						
						projects.add(new Project( res.getInt("id"),res.getString("pName"), StatusData.valueOf(res.getString("pStatus"))));
						
					 
					}
					
					
			} catch (Exception e) {
				e.printStackTrace();
			} 
	     }
	
		
		} 
		
		
		catch (SQLException e1) {
		
		e1.printStackTrace();
		
		}
		
		return projects;
		
			
}


	// Project details 
	public ArrayList<Project> getProjectDetails(int id) {
		ArrayList<Project> projects = new ArrayList<Project>();
		
	String sqlSelectPDetails = "SELECT * FROM Project WHERE id = ?";
	//String sqlSelectPRewards = "SELECT * FROM RewardData WHERE id = ?";
	
	try (Connection connection = DriverManager.getConnection(
			"jdbc:" + Configuration.getType() + "://"
					+ Configuration.getServer() + ":"
					+ Configuration.getPort() + "/"
					+ Configuration.getDatabase(), Configuration.getUser(),
			Configuration.getPassword())) {

		try (PreparedStatement ps2 = connection.prepareStatement(sqlSelectPDetails)
				){
			    
					ps2.setInt(1,id);
					
																											
			try (ResultSet rs = ps2.executeQuery()) {
				
				if(rs.next()) {
					
					projects.add(new Project( rs.getInt("id"),rs.getString("emailPS"),rs.getString("pName"),new PaymentData(rs.getString("name"),rs.getString("iban")), rs.getString("pDescription"),StatusData.valueOf(rs.getString("pStatus")), rs.getInt("fundingLimit"),rs.getTimestamp("endDate"),rs.getString("nameOfRewardPerAmount")));
								
						
				}
					
			}
		
		}
	} catch (Exception f) {
		f.printStackTrace();
	}

	return projects;
}
	
	
	

	/**
	 * Forwards a new project to the database.
	 * 
	 * @param emailPS
	 * @param payInfoPS
	 * @param pName 
	 * @param pDescription
	 * @param pStatus
	 * @param fundingLimit
	 * @param endDate
	 * @param nameOfRewardPerAmount
	 */
	
  @Override
	public void makeProject(String emailPS, PaymentData paydata, String pName ,String pDescription, int fundingLimit, Timestamp endDate,String nameOfRewardPerAmount) {
		
		// Declare SQL query to insert offer.
		String sqlInsertP = "INSERT INTO Project( emailPS,name, iban, pName, pDescription,pStatus, fundingLimit, endDate,nameOfRewardPerAmount) VALUES (?,?,?,?,?,'OPEN',?,?,?)";

		
		// Insert project into database.
		try (
				Connection dbConnection = null;
				Connection connection = DriverManager.getConnection(
				"jdbc:" + Configuration.getType() + "://"
						+ Configuration.getServer() + ":"
						+ Configuration.getPort() + "/"
						+ Configuration.getDatabase(), Configuration.getUser(),
				Configuration.getPassword())) {
			

			try (PreparedStatement ps = connection.prepareStatement(sqlInsertP)) {
				String []rewards = nameOfRewardPerAmount.split(";");
				
				ps.setString(1, emailPS);				
				ps.setString(2, paydata.getName());
				ps.setString(3, paydata.getIban());
				ps.setString(4, pName);				
				ps.setString(5, pDescription);
				ps.setInt(6, fundingLimit);
				ps.setTimestamp(7, endDate);
			for (String r:rewards) {ps.setString(8,r);}
							
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	
	
		
	
	/**
	 *  Marking projects as successful or Failed considering their deadline and fundinglimit.
	 */
	public void setProjectStatus() {
		
		/* TBD
		 * ArrayList<Donating>Donation = new ArrayList<Donating>();
		 * ArrayList<Project>projects = new ArrayList<Project>(); if
		 * (projects.get(0).getId()==Donation.get(5).getPid())
		 	
			{Double collectedDonation =  (Donation.get(4).getAmount()) ;}
		*/
		// Declare necessary SQL statement.
		String updateP = "UPDATE  Project" +"SET pStatus = CASE"+ "WHEN (endDate<date) AND (fundingLimit<=collectedDonation) THEN pStatus ='SUCCESSFUL'"+"WHEN (endDate<date) AND (fundingLimit>collectedDonation) THEN pStatus='FAILED'"+"ELSE pStatus END" ;
		
		// Update Database.
		try (Connection connection = DriverManager.getConnection(
				"jdbc:" + Configuration.getType() + "://"
						+ Configuration.getServer() + ":"
						+ Configuration.getPort() + "/"
						+ Configuration.getDatabase(), Configuration.getUser(),
				Configuration.getPassword())) {
			try (PreparedStatement psSetStatus= connection.prepareStatement(updateP)) {
				psSetStatus.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	 /****  
	  * We are Adding Donation for a project into Database based on parameter
	  * @param supporterData
	  * @param amount
	  * @param pid
	  *  
	  *    **/
	public  Donating addingDonation(SupporterData supporterData, double amount, int pid) {
	          
		Project p= null;
		ArrayList<Donating> donations = new ArrayList<Donating>();
		Donating donation = null;
		//System.out.println("before executing queries");
		String sqlSelectP = "SELECT * FROM Project WHERE id=? AND pStatus='OPEN'";
		String sqlSelectD = "SELECT * FROM Donating WHERE pid=?";
		String sqlInsertD = "INSERT INTO Donating (email, name,iban,amountToDonate,pid) VALUES (?,?,?,?,?)";
		
		// Insert Donation into database.
		
		
		try (
				Connection dbConnection = null;
				Connection connection = DriverManager.getConnection(
				"jdbc:" + Configuration.getType() + "://"
						+ Configuration.getServer() + ":"
						+ Configuration.getPort() + "/"
						+ Configuration.getDatabase(), Configuration.getUser(),
				Configuration.getPassword())) {
			

			try (PreparedStatement psSelectP = connection.prepareStatement(sqlSelectP);
					PreparedStatement psSelectD = connection.prepareStatement(sqlSelectD);
					PreparedStatement psInsertD = connection.prepareStatement(sqlInsertD,PreparedStatement.RETURN_GENERATED_KEYS)) 
			{
				
				psSelectP.setInt(1,pid);								
										
				try (ResultSet pos = psSelectP.executeQuery()) 
				{
					while (pos.next()) {
						p = new Project(pos.getInt("id"),pos.getString("emailPS"), pos.getString("pName"),new PaymentData(pos.getString("name"),pos.getString("iban")), pos.getString("pDescription"),StatusData.valueOf(pos.getString("pStatus")), pos.getInt("fundingLimit"),pos.getTimestamp("endDate"), pos.getString("nameOfRewardperAmount"));
													
					}
					
						}
				
				if ( p!= null) {
					psSelectD.setInt(1, pid);
					try (ResultSet dos = psSelectD.executeQuery()) {
						while (dos.next()) {
						 donations.add( new Donating(dos.getInt("id"), new SupporterData(new PaymentData(dos.getString("name"),dos.getString("iban")),dos.getString("email")),dos.getDouble("amountToDonate"), dos.getInt("pid")));
									
						}
						p.setDonations(donations);
					}
				
					donation = new Donating(0,supporterData,amount,p.getId());
					//donation.getSupporterData();
					psInsertD.setString(1,donation.getSupporterData().getEmail());
					psInsertD.setString(2, donation.getSupporterData().getPayInfo().getName());
					psInsertD.setString(3, donation.getSupporterData().getPayInfo().getIban());
					psInsertD.setDouble(4, donation.getAmount());
					psInsertD.setInt(5,donation.getPid());
					psInsertD.executeUpdate();
					/*
					 * try (ResultSet rs = psInsertD.getResultSet()) { while(rs.next()) {
					 * donation.setId(rs.getInt(1)); } }
					 */
					
				
				}
				//else p= null;	
			}
			catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			

				
				
			
					
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
			
		return donation;
	
}
	public boolean checkProjectsByIdAndStatus(int pid) {
		String queryPIDStatus = "SELECT FROM Project WHERE id=? AND pStatus= 'OPEN'";
		
		try (Connection connection = DriverManager.getConnection(
				"jdbc:" + Configuration.getType() + "://"
						+ Configuration.getServer() + ":"
						+ Configuration.getPort() + "/"
						+ Configuration.getDatabase(), Configuration.getUser(),
				Configuration.getPassword())) {
			try (PreparedStatement psSelect = connection
					.prepareStatement(queryPIDStatus)) {
				psSelect.setInt(1, pid);
				try (ResultSet rs = psSelect.executeQuery()) {
					return rs.next();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	



	




	
}
		
	

