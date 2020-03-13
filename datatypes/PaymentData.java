
  package datatypes;
  //Data type for payment information
  
  public class PaymentData { 
	  private static String name; 
	  private static String iban;
  
  
  public PaymentData(String name, String iban)
  {
  PaymentData.name = name;
  PaymentData.iban = iban; } 
  public  String getName() { 
	  return name; } 
  public String getIban() { 
	  return iban; }
  }
 