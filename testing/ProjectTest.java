	package testing;

import static org.junit.Assert.assertTrue;
import java.sql.Connection;
import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import datatypes.PaymentData;
import datatypes.StatusData;
import datatypes.SupporterData;
import dbadapter.Donating;
import dbadapter.Project;
import junit.framework.TestCase;

/**
 * Testing our Project.
 * 
 * @author GR23
 *
 */
public class ProjectTest extends TestCase{
	
	Project p;
	@Before 
	public void setUp() throws Exception{
		
		PaymentData PI = new PaymentData ("Nona","DE1234567899");
			
		p = new Project (122,"max10@uni-due.de",  "Save The World",PI,"Some Description",StatusData.valueOf("OPEN"),200,Timestamp.valueOf("2020-01-30 00:00:00"),"Pizza:100");
		
	}
	
	@Test 
	public final void  testGetId() {
		assertEquals(122,p.getId());}
	@Test 
	public final void  testEmailPs() {
		assertEquals("max10@uni-due.de",p.getEmailPS());}
	
	@Test 
	public final void  testGetName() {
		assertEquals("Nona",p.getPayInfoPS().getName());}

	@Test 
	public final void  testGetIban() {
		assertEquals("DE1234567899",p.getPayInfoPS().getIban());}
	@Test 
	public final void  testPname() {
		assertEquals("Save The World",p.getpName());}
	@Test 
	public final void  testpDescription() {
		assertEquals("Some Description",p.getpDescription());}
	
	@Test 
	public final void  testpStatus() {
		assertEquals("OPEN",p.getpStatus().toString());}
	
	@Test 
	public final void  testFundingLimit() {
		assertEquals(200,p.getFundingLimit());}
	
}
