	package testing;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import datatypes.StatusData;
import dbadapter.Configuration;
import dbadapter.DBFacade;
import dbadapter.Project;

/**
 * Testing our DBFacade.
 * 
 * @author GR23
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(DBFacade.class)
public class DBFacadeTest {
	
	private Connection stubCon;
	private String sqlSelectP;
	private String sqlSelectPDetails;
	private PreparedStatement ps;
	private PreparedStatement ps2;
	private ResultSet res;
	private ResultSet rs;

	/**
	 * Preparing classes with static methods
	 */
	@Before
	public void setUp() {
		PowerMockito.mockStatic(DriverManager.class);

		// Declare necessary SQL queries
		String sqlSelectP = "SELECT id,pName, pStatus FROM Project WHERE pStatus = ?";
		String sqlSelectPDetails = "SELECT * FROM Project WHERE id = ?";
		//sqlSelectP = "SELECT * FROM Donating WHERE pid = ?";

		// Mock return values
		//ps = mock(PreparedStatement.class);
		ps2 = mock(PreparedStatement.class);
		//res = mock(ResultSet.class);
		rs = mock(ResultSet.class);

		try {
			// Setting up return values for connection and statements
			stubCon = mock(Connection.class);
			PowerMockito.when(DriverManager.getConnection(
					"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
							+ Configuration.getPort() + "/" + Configuration.getDatabase(),
					Configuration.getUser(), Configuration.getPassword())).thenReturn(stubCon);

			//when(stubCon.prepareStatement(sqlSelectP)).thenReturn(ps);
			when(stubCon.prepareStatement(sqlSelectPDetails)).thenReturn(ps2);
			//when(ps.executeQuery()).thenReturn(res);
			when(ps2.executeQuery()).thenReturn(rs);

			/*
			 * // Setting up return values for methods
			 * when(res.next()).thenReturn(true).thenReturn(false);
			 * when(res.getInt(1)).thenReturn(0);
			 * when(res.getString(4)).thenReturn("Project Name");
			 * when(res.getString(6)).thenReturn("OPEN"));
			 */

			
			  // Setting up return values for corresponding project details
			  when(rs.next()).thenReturn(true).thenReturn(false);
			  when(rs.getInt(0)).thenReturn(0);
			  when(rs.getString(1)).thenReturn("peter@uni-due.de ");
			 // when(rs.getString(3)).thenReturn("Name");
			 //when(rs.getString(4)).thenReturn("IBAN");
			  when(rs.getString(4)).thenReturn("Project Name");
			  when(rs.getString(5)).thenReturn("Some Description of this Project");
			 // when(rs.getString(6)).thenReturn(StatusData.OPEN.toString());
			  when(rs.getInt(7)).thenReturn(1000);
			  when(rs.getTimestamp(8)).thenReturn(Timestamp.valueOf("2020-01-31 00:00:00")); 
			  when(rs.getString(9)).thenReturn("award1:200");
			  System.out.println("try");
			 	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	/*
	 * @Test public void testGetProject() {
	 * 
	 * String p = "OPEN"; ArrayList<Project> projects =
	 * DBFacade.getInstance().getProject(p);
	 * 
	 * 
	 * // Verify how often a method has been called try { verify(stubCon,
	 * times(1)).prepareStatement(sqlSelectP); verify(ps, times(1)).executeQuery();
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * // Verify return values assertTrue(projects.size() == 1);
	 * assertTrue(projects.get(0).getId() == 0);
	 * assertTrue(projects.get(0).getpName()== "Project Name");
	 * assertTrue(projects.get(0).getpStatus().toString() ==("OPEN"));
	 * System.out.println("Here "+projects.get(0).getpStatus().toString());
	 * 
	 * }
	 */
	
	@Test
	public void testGetProjectDetails() {
		
	     int p= 122;
		ArrayList<Project> projects = DBFacade.getInstance().getProjectDetails(p);
		
		
		// Verify how often a method has been called
		try {
			verify(stubCon, times(1)).prepareStatement(sqlSelectPDetails);
			verify(ps2, times(1)).executeQuery();
		      } 
				catch (SQLException e) {
						e.printStackTrace();
					}
		
		// Verify return values
		assertTrue(projects.size() == 1);
		assertTrue(projects.get(0).getId() == 0);
		assertTrue(projects.get(0).getEmailPS()=="peter@uni-due.de");		
		assertTrue(projects.get(0).getpName()== "Project Name");
		assertTrue(projects.get(0).getpDescription()=="Some Description of this Project");
		//assertTrue(projects.get(0).getpStatus().toString() ==("OPEN"));
		assertTrue(projects.get(0).getFundingLimit()==1000);	
		assertTrue(projects.get(0).getEndDate().equals(Timestamp.valueOf("2020-01-31 00:00:00"))); 
		assertTrue(projects.get(0).getNameOfRewardPerAmount()=="award1:200");
		
		System.out.println("Here "+projects.get(0).getpStatus().toString());
		
	}


}
