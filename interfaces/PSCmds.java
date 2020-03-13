package interfaces;

import datatypes.PaymentData;
/**
 * Interface that provides all methods for the interaction with the project Starter.
 * 
 * @author swe.uni-due.de
 *
 */
public interface PSCmds {

	//public void requestMakeProject(String emailPS, PaymentData payInfoPS, String pName, String pDescription, String fundingLimit, String endDate, RewardData rewardList);

	public void requestMakeProject(String emailPS, PaymentData payInfoPS, String pName, String pDescription, String fundingLimit, String endDate,String nameOfRewardPerAmount);

	

	
}
