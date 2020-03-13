package interfaces;

import java.util.ArrayList;

//import datatypes.StatusData;
import datatypes.SupporterData;
import dbadapter.Donating;

//import datatypes.PaymentData;
//import datatypes.StatusData;
//import datatypes.SupporterData;
//import dbadapter.Donating;
import dbadapter.Project;

/**
 * Interface that provides all method to interact with a guest.
 * 
 * @author GR23
 *
 */
public interface SCmds {	

	  public ArrayList<Project> queryProject( String pStatus);
	  //public ArrayList<Project> queryProjectDetails( int id);
	
	  public Donating requestAddDonation(SupporterData supporterData, String amountToDonate, String pid);
	ArrayList<Project> queryProjectDetails(String id);
		
	
	
}
