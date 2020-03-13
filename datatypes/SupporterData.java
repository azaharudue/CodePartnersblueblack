package datatypes;

/**
 * Contains the necessary informations about a supporter.
 * 
 * @author GR23
 *
 */
public class SupporterData {
	private PaymentData payInfo;
	private  String email;

	public SupporterData(PaymentData payInfoS, String email) {
		this.payInfo = payInfoS;
		this.email = email;	
	}

	public PaymentData getPayInfo() {
		return payInfo;
	}

	public  String getEmail() {
		return email;
	}
}
