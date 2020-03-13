package dbadapter;

import java.sql.Timestamp;
import java.util.ArrayList;
import datatypes.PaymentData;
//import datatypes.RewardData;
import datatypes.StatusData;

/**
 * Class representing an offer
 * 
 * Forwards a new project to the database.
 * 
 *
 */

public class Project {

	private int id;
	private String emailPS;
	private PaymentData payInfoPS;
	private String pName;
	private String pDescription;
	private int fundingLimit;
	private StatusData pStatus;
	private Timestamp endDate;
	private String nameOfRewardPerAmount;
	// private ArrayList<RewardData> rewardList;
	private ArrayList<Donating> donations;

	public Project(int id, String emailPS, String pName, PaymentData payInfoPS, String pDescription, StatusData pStatus,
			int fundingLimit, Timestamp endDate,String nameOfRewardPerAmount) {
		super();
		this.id = id;
		this.emailPS = emailPS;
		this.payInfoPS = payInfoPS;
		this.pName = pName;
		this.pDescription = pDescription;
		this.pStatus = pStatus;
		this.fundingLimit = fundingLimit;
		this.endDate = endDate;
		this.nameOfRewardPerAmount=nameOfRewardPerAmount;
		// this.setRewardList(new ArrayList<RewardData>());
		this.setDonations(new ArrayList<Donating>());
	}

	public Project(int id, String pName, StatusData pStatus) {
		this.id = id;
		this.pName = pName;
		this.pStatus = pStatus;
	}

	public Project() {
		super();
	}

	

	@Override
	public String toString() {
		
		return "Project [id=" + id + ", emailPS=" + emailPS + ", payInfoPS=" + payInfoPS + ", pName=" + pName
				+ ", pDescription=" + pDescription + ", fundingLimit=" + fundingLimit + ", pStatus=" + pStatus
				+ ", endDate=" + endDate + ", nameOfRewardPerAmount=" + nameOfRewardPerAmount+ "]";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the emailPS
	 */
	public String getEmailPS() {
		return emailPS;
	}

	/**
	 * @param emailPS the emailPS to set
	 */
	public void setEmailPS(String emailPS) {
		this.emailPS = emailPS;
	}

	/**
	 * @return the payInfoPS
	 */
	public PaymentData getPayInfoPS() {
		return payInfoPS;
	}

	/**
	 * @param payInfoPS the payInfoPS to set
	 */
	public void setPayInfoPS(PaymentData payInfoPS) {
		this.payInfoPS = payInfoPS;
	}

	/**
	 * @return the pName
	 */
	public String getpName() {
		return pName;
	}

	/**
	 * @param pName the pName to set
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}

	/**
	 * @return the pDescription
	 */
	public String getpDescription() {
		return pDescription;
	}

	/**
	 * @param pDescription the pDescription to set
	 */
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	/**
	 * @return the fundingLimit
	 */
	public int getFundingLimit() {
		return fundingLimit;
	}

	/**
	 * @param fundingLimit the fundingLimit to set
	 */
	public void setFundingLimit(int fundingLimit) {
		this.fundingLimit = fundingLimit;
	}

	/**
	 * @return the pStatus
	 */
	public StatusData getpStatus() {
		return pStatus;
	}

	/**
	 * @param string the pStatus to set
	 */

	/**
	 * @return the endDate
	 */
	public Timestamp getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
		
	}

	/**
	 * @return the rewardList
	 */
	/*
	 * public ArrayList<RewardData> getRewardList() { return rewardList; }
	 * 
	 * 
	 *//**
		 * @param rewardList the rewardList to set
		 *//*
			 * public void setRewardList(ArrayList<RewardData> rewardList) { this.rewardList
			 * = rewardList; }
			 */

	public void setpStatus(StatusData pStatus) {
		this.pStatus = pStatus;
	}

	public String getNameOfRewardPerAmount() {
		return nameOfRewardPerAmount;
	}

	public void setNameOfRewardPerAmount(String nameOfRewardPerAmount) {
		this.nameOfRewardPerAmount = nameOfRewardPerAmount;
	}

	public void setDonations(ArrayList<Donating> donations) {
		this.donations = donations;

	}

	public ArrayList<Donating> getDonations() {
		return donations;
	}

}
