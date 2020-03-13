package dbadapter;

import datatypes.SupporterData;

/**
 * Class representing a donation
 * 
 * @author GR23
 *
 */
public class Donating {

	private int id;
	private SupporterData supporterData;
	private double amount;
	private int pid;

	public Donating(int id, SupporterData supporterData, double amountToDonate, int pid) {
		super();
		this.id= id;
		this.supporterData=supporterData;
		this.amount= amountToDonate;
		this.pid=pid;
		
		
		}


	public int getId() {
		return id;
	}



	public void setId(int did) {
		this.id = did;
	}



	public SupporterData getSupporterData() {
		return supporterData;
	}



	public void setSupporterData(SupporterData supporterData) {
		this.supporterData = supporterData;
	}


	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public int getPid() {
		return pid;
	}



	public void setPid(int pid) {
		this.pid = pid;
	}

}

