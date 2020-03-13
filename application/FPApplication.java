package application;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import datatypes.PaymentData;
import datatypes.StatusData;
import datatypes.SupporterData;
import dbadapter.DBFacade;
import dbadapter.Project;
//import datatypes.RewardData;
import dbadapter.Donating;
import dbadapter.EmailAdapter;
import interfaces.ITimer;
import interfaces.PSCmds;
import interfaces.SCmds;

/**
 * This class contains the FPApplication which acts as the interface between all
 * components.
 * 
 * @author GR23
 *
 *
 */

public class FPApplication implements PSCmds,SCmds,ITimer {

	private static FPApplication instance;

	/**
	 * Implementation of the Singleton pattern.
	 * 
	 * @return
	 */
	public static FPApplication getInstance() {
		if (instance == null) {
			instance = new FPApplication();
		}

		return instance;
	}

	/**
	 * Forwards a new project to the database.
	 * 
	 * @param emailPS
	 * @param payInfoPS
	 * @param pName
	 * @param pDescription
	 * @param fundingLimit
	 * @param endDate
	 * @param rewardList
	 */
	
	@Override
	
	public void requestMakeProject(String emailPS, PaymentData payInfoPS, String pName,String pDescription, String fundingLimit, String endDate,String nameOfRewardPerAmount) {

		// Parse inputs to correct datatypes
		try {
			
			  DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); 
			  Date date = dateFormat.parse(endDate); 
			  long time = date.getTime(); 
			  Timestamp endDateSQL = new Timestamp(time); 			 
			  int fundingLimitSQL= Integer.parseInt(fundingLimit);	
			  //StatusData pStatus = pStatus.OPEN; 
			  
			  DBFacade.getInstance().makeProject(emailPS, payInfoPS, pName,pDescription,fundingLimitSQL, endDateSQL, nameOfRewardPerAmount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
@Override

	public ArrayList<Project> queryProject(String pStatus) {
				ArrayList<Project> projects = null;
				
			//	StatusData pStatusSQL = StatusData.valueOf(pStatus);
				
				try {
					projects = DBFacade.getInstance().getProject(pStatus);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
		
				return projects;
		
		
	  }

	
	
@Override
	public ArrayList<Project> queryProjectDetails(String id) {
	
		ArrayList<Project> result = null;
		int pid = Integer.parseInt(id);
		
		try {
			result = DBFacade.getInstance().getProjectDetails(pid);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return result;
	}

	
	
	/**
	 * Initiates to check end date and funding limit of open projects 
	 */
	

	public void checkEndDate() {
		
		DBFacade.getInstance().setProjectStatus();
		
		
		//if (result.get(6).equals(StatusData.SUCCESSFUL){EmailAdapter.getInstance().sendProjectStatusSuccessful(email, mailtext);}
	}



	
	
	  @Override 
	  public Donating requestAddDonation(SupporterData supporterData, String amountToDonate, String pid) 
	  {    
		 assert preProjectOpen(Integer.parseInt(pid)): "Precondition not satisfied";
		  
		  Donating okfail = null;
		  double amountSQL = Double.parseDouble(amountToDonate);
		
		  int pidSQL = Integer.parseInt(pid);
	  
	  try { 
	  okfail= DBFacade.getInstance().addingDonation(supporterData,amountSQL,pidSQL); }
	  catch (Exception e) {
	  
	  e.printStackTrace();
	  
	  } 
	  return okfail;
	 }
	  
	  /**
		 * Checks precondition Project exists
		 * 
		 * @param pid
		 * @return
		 */
	
	  //checks if a project with the did is existing and its status id open private
	  boolean preProjectOpen(int pid) { return
	  DBFacade.getInstance().checkProjectsByIdAndStatus(pid); }

	

	  

	
	

}

