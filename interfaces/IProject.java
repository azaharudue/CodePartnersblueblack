package interfaces;
import java.sql.Timestamp;
import java.util.ArrayList;

import datatypes.PaymentData;
//import datatypes.RewardData;
import datatypes.StatusData;
import dbadapter.Project;

/**
 * Interface for DBFacade to provide all necessary database function.
 * 
 * @author GR23
 *
 */
public interface IProject {

	
	  //public Project makeProject(String emailPS, PaymentData payInfoPS, String pName,StatusData pStatus ,int fundingLimit, Timestamp endDate,String rewardlist);

	  public ArrayList<Project> getProject( String pStatus);
	  public ArrayList<Project> getProjectDetails( int id); 
	  public  void setProjectStatus();

	void makeProject(String emailPS, PaymentData paydata, String pName, String pDescription, int fundingLimit,
			Timestamp endDate, String nameOfRewardPerAmount);
		
	
	
}
