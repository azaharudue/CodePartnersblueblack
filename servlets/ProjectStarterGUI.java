package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import application.FPApplication;
import datatypes.*;

/**
 * Contains GUI for projectstarter
 * @author GR23
 *
 */
public class ProjectStarterGUI extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	/**
	 * doGet contains the Enter Funding Request form
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		// set pagetitle und navtype
		
		request.setAttribute("navtype", "projectstarter");
		request.setAttribute("pagetitle", "Enter Funding Request");

		// Dispatch request to template engine
		try {
			request.getRequestDispatcher("/templates/defaultWebpagePS.ftl").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Contains handling of  call
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("navtype", "projectstarter");

		// Check weather the call is requestMakeProject or not
		if (request.getParameter("action").equals("requestMakeProject")) {

			// Append parameter of request
			String emailPS = (String) request.getParameter("emailPS");
			String name = (String) request.getParameter("name");
			String iban = (String) request.getParameter("iban");						
			String pName = (String) request.getParameter("pName");		
			String pDescription = (String) request.getParameter("pDescription");
			String fundingLimit = (String) request.getParameter("fundingLimit");
			String endDate = (String) request.getParameter("endDate");
			String nameOfRewardPerAmount = (String)request.getParameter("nameOfRewardPerAmount");
			
			
			// Call application to create a project
			new FPApplication().requestMakeProject(emailPS, new PaymentData(name, iban), pName,pDescription, 
					fundingLimit, endDate,nameOfRewardPerAmount);
			

			// Dispatch message to template engine
			try {
				request.setAttribute("pagetitle", "Enter a Funding Request");
				request.setAttribute("message", "New Project is  successfully stored in the database.");
				request.getRequestDispatcher("/templates/fundingProjectRep.ftl").forward(request, response);

			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			// Call doGet if request is not equal to requestMakeProject
		} else
			
			doGet(request, response);
		

	}
}