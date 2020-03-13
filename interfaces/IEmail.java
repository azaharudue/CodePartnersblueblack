package interfaces;


public interface IEmail {

	public void sendProjectStatusSuccessful(String email,String mailtext );

	void sendProjectStatusFailed(String email, String mailtext);


}
