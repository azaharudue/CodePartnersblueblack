package testing;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.junit.WebTester;

/**
 * This class performs a system test on the SupporterGUI using JWebUnit.
 * 
 * @author GR23
 *
 */
public class SupporterGUIWebTestCase {

	private WebTester tester;

	/**
	 * Create a new WebTester object that performs the test.
	 */
	@Before
	public void prepare() {
		tester = new WebTester();
		tester.setBaseUrl("http://localhost:8080/fp/");
	}

	@Test
	public void testQueryProject() {
		
		// Start testing for supportergui
		
		tester.beginAt("supportergui");

		// Check all components of the search form
		tester.assertTitleEquals("Search Project");
		tester.assertFormPresent();
		tester.assertTextPresent("Required Information");
		tester.assertTextPresent("OPEN");
		tester.assertFormElementPresent("pStatus");
		tester.assertTextPresent("SUCCESSFUL");
		tester.assertFormElementPresent("pStatus");
		tester.assertTextPresent("FAILED");
		tester.assertFormElementPresent("pStatus");
		tester.assertButtonPresent("selectPPage");

		// Submit the form with given parameters
		tester.setTextField("pStatus", "OPEN");
		tester.setTextField("pStatus", "");
		tester.setTextField("pStatus", "");

		tester.clickLink("selectPPage");

		// Check the representation of the table for an empty result
		tester.assertTablePresent("projects");
		String[][] tableHeadings = { { "ID", "Name", "Status" } };
		tester.assertTableEquals("projects", tableHeadings);
	
	}
	
	@Test
	public void testQueryProjectDetails() {
		
		// Start testing for supportergui
		
		tester.beginAt("supportergui/selectPPage");
		// Check all components of Project Details Representation 
		tester.assertTitleEquals("Details of this Project");		
		tester.assertTextPresent("All information about the selected project!");
		tester.assertTextPresent("Donate For this project!");	
		tester.clickLink("selectToDonate");
		// Check the representation of the table for an empty result
		tester.assertTablePresent("project");
		String[][] tableHeadings = { { "ID", "Project Name", "Email Of Project Starter","Project Description","Project Status","Funding Limit","Dead line"} };
		tester.assertTableEquals("project", tableHeadings);
	
	}
	@Test
	public void testRequestAddDonation() {
		
		// Start testing for supportergui
		
		tester.beginAt("supportergui/selectToDonate");
		// Check all components for donation entries.
		tester.assertFormPresent();
		tester.assertTextPresent("Required Information");	
		tester.assertTextPresent("Supporter Name");
		tester.assertFormElementPresent("name");
		tester.assertTextPresent("Supporter Email");
		tester.assertFormElementPresent("email");
		tester.assertTextPresent("Supporter IBAN");
		tester.assertFormElementPresent("iban");
		tester.assertTextPresent("Amount To Donate");
		tester.assertFormElementPresent("amountToDonate");
		tester.assertButtonPresent("");
		
		
	}
}
