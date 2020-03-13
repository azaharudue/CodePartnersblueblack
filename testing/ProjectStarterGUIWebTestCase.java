package testing;


import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import datatypes.PaymentData;
import datatypes.StatusData;
import dbadapter.Project;
import net.sourceforge.jwebunit.junit.WebTester;



public class ProjectStarterGUIWebTestCase {
	
	private WebTester tester; 
	Project p;
	
	@Before
	public void prepare() {
		
		tester.setBaseUrl("http://localhost:8080/fp/");
	}
	@Test
	public  void requestMakeProjectTest () {
		// start testing for project starter 
		tester.beginAt("projectstartergui");
		// Check all components for creating project  form
		//tester.assertTitleEquals("Enter a Funding Request");
		tester.assertFormPresent();
		tester.assertTextPresent("Required Informations to create a funding request");
		tester.assertTextPresent("Email");
		tester.assertFormElementPresent("emailPS");
		tester.assertTextPresent("Name");
		tester.assertFormElementPresent("name");
		tester.assertTextPresent("IBAN ");
		tester.assertFormElementPresent("iban");
		tester.assertTextPresent("Project Name ");
		tester.assertFormElementPresent("pName");
		tester.assertTextPresent("Project Description ");
		tester.assertFormElementPresent("pDescription");
		tester.assertTextPresent("Funding Limit");
		tester.assertFormElementPresent("fundingLimit");
		tester.assertTextPresent("End Date ");
		tester.assertFormElementPresent("endDate");
		tester.assertTextPresent("Name of Rewards [Please Use this format : NameOfReward1:Amount1;NameOfReward2:Amount2] ");
		tester.assertFormElementPresent("nameOfRewardPerAmount");		
		tester.assertButtonPresent("Submit");
			//Submit the form with given parameters
				p = new Project(1, "gr23@uni-due.de", "Donation for upcoming environment pollution solution project",new PaymentData ("Group 23","DE123456789"),
						"Let's save the world",StatusData.valueOf("OPEN"),20000,Timestamp.valueOf("2020-02-02 00:00:00"),"OliveTree: 200");
			
	
		}
}