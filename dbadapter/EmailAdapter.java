package dbadapter;

import interfaces.IEmail;

public class EmailAdapter implements IEmail {
	private static EmailAdapter instance;

	/**
	 * Implementation of the Singleton pattern.
	 * 
	 * @return
	 */
	public static EmailAdapter getInstance() {
		if (instance == null) {
			instance = new EmailAdapter();
			
		}

		return instance;
	}

	/**
	 * Stub for an email-adapter. Instead of actually sending a mail, it gets
	 * printed to the console.
	 * */

	@Override
	public void sendProjectStatusSuccessful(String email, String mailtext) {
		
		System.out.println("email to  <"+ email+">");
		System.out.println();
		System.out.println("The project is successful.");		
	
	}
	@Override
	public void sendProjectStatusFailed(String email, String mailtext) {
		
		System.out.println("email to  <"+ email+">");
		System.out.println();
		System.out.println("The project is failed.");
		
	}
	
}
