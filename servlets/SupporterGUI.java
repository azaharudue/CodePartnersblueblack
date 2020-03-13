package servlets;

import java.io.IOException;
//import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.FPApplication;
//import application.FPApplication;
import datatypes.PaymentData;
import datatypes.StatusData;
import datatypes.SupporterData;
//import dbadapter.Donating;
//import datatypes.SupporterData;
import dbadapter.Project;

/**
 * Class responsible for the GUI of the guest
 * 
 * @author swe.uni-due.de
 *
 */
public class SupporterGUI extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	/**
	 * doGet is responsible for search form and booking form
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		// Set navtype
		request.setAttribute("navtype", "supporter");
		
		

		// Catch error if there is no page contained in the request
		String action = (request.getParameter("action") == null) ? "" : request.getParameter("action");

		// Case: Request search form
		if (action.equals("queryProject")) {
			// Set request attributes
			StatusData[] pStatus =StatusData.values();
			request.setAttribute("pStatus", pStatus);
			request.setAttribute("pagetitle",  "Search Project");
			request.setAttribute("pStatus", StatusData.valueOf(request.getParameter("pStatus")));
			
			

			// Dispatch request to template engine
			try {
				request.getRequestDispatcher("/templates/defaultWebpageS.ftl").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
						
		} 
		else if (action.equals("selectPPage")) {
			
			// Set request attributes
			
			request.setAttribute("id", request.getParameter("id"));
				
				// Decide whether booking was successful or not
				//Set request attributes
				 	List <Project> project = null;
					request.setAttribute("pagetitle", "Details of this Project");
					request.setAttribute("message","All information about the selected project!");

					// Dispatch to template engine
					try {
						
						 
						 project =	FPApplication.getInstance().queryProjectDetails(request.getParameter("id") );
						 
						request.setAttribute("project", project);
						request.getRequestDispatcher("/templates/projectDetailsRepresentation.ftl").forward(request, response);
					} catch (ServletException | IOException e) {
						e.printStackTrace();
					}

				}	
		
		else if (action.equals("selectToDonate")) {
			
			request.setAttribute("pagetitle", "Donate for this Project");
			request.setAttribute("pid", request.getParameter("pid"));

			// Dispatch request to template engine
			try {
				// Otherwise show search form
				request.getRequestDispatcher("/templates/showDonationForm.ftl").forward(request, response);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		else  {	
			// Otherwise show search project details form

			request.setAttribute("pagetitle",  "search Project");
			try {
				request.getRequestDispatcher("/templates/defaultWebpageS.ftl").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
	}
		


	/**
	 * doPost manages handling of submitted forms.
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		// Set attribute for navigation type.
		request.setAttribute("navtype", "supporter");
		
		// Generate and show results of a search
				if (request.getParameter("action").equals("queryProject"))
				
				{
					request.setAttribute("pagetitle", "Search results");
					List<Project> projects = null;
					
					// Call application to request the results
					try {
						  
								 projects = FPApplication.getInstance().queryProject(request.getParameter(("pStatus")));
						// Dispatch results to template engine
						
						
						request.setAttribute("projects", projects);
						
						
						request.getRequestDispatcher("/templates/projectRepresentation.ftl").forward(request, response);
					
					} 
					catch (Exception e1) {
						try {
							request.setAttribute("errormessage", "Database error: please contact the administator");
							request.getRequestDispatcher("/templates/error.ftl").forward(request, response);
						} catch (Exception e) {
							request.setAttribute("errormessage", "System error: please contact the administrator");
							e.printStackTrace();
						}
									
							// Catch booking error and print an error on the gui
		  
					}
		  
		 
		  	
				}
				
				
				
				
					// set attribute request 
				
				
				 else if (request.getParameter("action").equals("requestAddDonation"))
					 
				  {
					 
				     
				  		  //Call application to request the results try 
				    			  
				  if(FPApplication.getInstance().requestAddDonation( new SupporterData (new
				  PaymentData( request.getParameter ("email"),request.getParameter("iban")),
				  request.getParameter("name")),request.getParameter("amountToDonate"),request.getParameter("pid" ))!=null)
				  {
					  // Set request attributes
						request.setAttribute("pagetitle", "Donation Successful");
						request.setAttribute("message","Donation successfully added. Thanks for your contribution");

						// Dispatch to template engine
						try {
							request.getRequestDispatcher("/templates/okRepresentation.ftl").forward(request, response);
						} catch (ServletException | IOException e) {
							e.printStackTrace();
						}

						// Catch donation error and print an error on the gui
					} else {
						request.setAttribute("pagetitle", "Donation failed");
						request.setAttribute("message","Donation failed. The selected project is no longer open.");

						try {
							request.getRequestDispatcher("/templates/failInfoRepresentation.ftl").forward(request,
									response);
						} catch (ServletException | IOException e) {
							e.printStackTrace();
						}

					}
					// If there is no page request, call doGet to show standard gui for
					// guest
				  }
			
				
				else
					doPost(request, response);
			}
		}
	
