	package testing;

import static org.junit.Assert.assertTrue;
import java.sql.Connection;
import org.junit.Before;
import org.junit.Test;

import datatypes.PaymentData;
import datatypes.SupporterData;
import dbadapter.Donating;
import junit.framework.TestCase;

/**
 * Testing our Donating.
 * 
 * @author GR23
 *
 */
public class DonatingTest extends TestCase{
	SupporterData sd;
	Donating d;
	@Before 
	public void setUp() throws Exception{
		
		sd = new SupporterData (new PaymentData("Max","DE1234566789"),"max@uni-due.de");
		d = new Donating (1,sd,122.00,122);
		
	}
	@Test 
	public final void  testGetAmount() {
		assertEquals(122.0,d.getAmount());}
	@Test 
	public final void  testGetId() {
		assertEquals(1,d.getId());}
	@Test 
	public final void  testGetName() {
		assertEquals("Max",d.getSupporterData().getPayInfo().getName());}	
	@Test 
	public final void  testGetEmail() {
		assertEquals("max@uni-due.de",d.getSupporterData().getEmail());}	
	@Test 
	public final void  testGetIban() {
		assertEquals("DE1234566789",d.getSupporterData().getPayInfo().getIban());}	
	
	

}
