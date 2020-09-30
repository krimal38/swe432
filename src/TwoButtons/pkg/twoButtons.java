package TwoButtons.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Import Java Libraries
import java.io.*;
import java.util.*;

//Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;

//twoButtons class
//CONSTRUCTOR: no constructor specified (default)
//
//***************  PUBLIC OPERATIONS  **********************************
//public void doPost ()  --> prints a blank HTML page
//public void doGet ()  --> prints a blank HTML page
//private void PrintHead (PrintWriter out) --> Prints the HTML head section
//private void PrintBody (PrintWriter out) --> Prints the HTML body with
//           the form. Fields are blank.
//private void PrintBody (PrintWriter out, String lhs, String rhs, String rslt)
//           Prints the HTML body with the form.
//           Fields are filled from the parameters.
//private void PrintTail (PrintWriter out) --> Prints the HTML bottom
//***********************************************************************



/**
 * Servlet implementation class twoButtons
 */
public class twoButtons extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Location of servlet.
	/*static String Domain  = "cs.gmu.edu:8443";
	static String Path    = "/offutt/servlet/";
	static String Servlet = "twoButtons";*/

	// Button labels
	static String OperationAdd = "Add";
	static String OperationSub = "Subtract";

	// Other strings.
	static String Style ="https://www.cs.gmu.edu/~offutt/classes/432/432-style.css";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public twoButtons() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		   PrintWriter out = response.getWriter();
		   PrintHead(out);
		   PrintBody(out);
		   PrintTail(out);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Float rslt   = new Float(0.0);
		   Float lhsVal = new Float(0.0);
		   Float rhsVal = new Float(0.0);
		   String operation = request.getParameter("Operation");
		   String lhsStr = request.getParameter("LHS");
		   String rhsStr = request.getParameter("RHS");
		  /* if ((lhsStr != null) && (lhsStr.length() > 0))
		      lhsVal = new Float(lhsStr);
		   if ((rhsStr != null) && (rhsStr.length() > 0))
		      rhsVal = new Float(rhsStr);*/
		   String Val = "";
		   

		   // change the code
		   if (operation.equals(OperationAdd))
		   {
			   Val = lhsStr + rhsStr;
		     // rslt = new Float(lhsVal.floatValue() + rhsVal.floatValue());
		   }
		   else if (operation.equals(OperationSub))
		   {
			   Val =  rhsStr + lhsStr;
		    // rslt = new Float(lhsVal.floatValue() - rhsVal.floatValue());
		   }

		   response.setContentType("text/html");
		   PrintWriter out = response.getWriter();
		   PrintHead(out);
		  // PrintBody(out, lhsStr, rhsStr, rslt.toString());
		   PrintBody(out, lhsStr, rhsStr, Val);
		   PrintTail(out);
	}
	
	private void PrintHead (PrintWriter out)
	{
	   out.println("<html>");
	   out.println("");

	   out.println("<head>");
	   out.println("<title>Two buttons example</title>");
	   out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"" + Style + "\">");
	   out.println("</head>");
	   out.println("");
	} // End PrintHead
	
	private void PrintBody (PrintWriter out, String lhs, String rhs, String rslt)
	{
	   out.println("<body>");
	   out.println("<p>");
	   out.println("A simple example that demonstrates how to operate with");
	   out.println("multiple submit buttons.");
	   out.println("</p>");
	   out.print  ("<form method=\"post\"");
	  // out.println(" action=\"https://" + Domain + Path + Servlet + "\">");
	   out.println("");
	   out.println(" <table>");
	   out.println("  <tr>");
	   out.println("   <td>First value:");
	   out.println("   <td><input type=\"text\" name=\"LHS\" value=\"" + lhs + "\" size=5>");
	   out.println("  </tr>");
	   out.println("  <tr>");
	   out.println("   <td>Second value:");
	   out.println("   <td><input type=\"text\" name=\"RHS\" value=\"" + rhs + "\" size=5>");
	   out.println("  </tr>");
	   out.println("  <tr>");
	   out.println("   <td>Result:");
	   out.println("   <td><input type=\"text\" name=\"RHS\" value=\"" + rslt + "\" size=6>");
	   out.println("  </tr>");
	   out.println(" </table>");
	   out.println(" <br>");
	   out.println(" <br>");
	   out.println(" <input type=\"submit\" value=\"" + OperationAdd + "\" name=\"Operation\">");
	   out.println(" <input type=\"submit\" value=\"" + OperationSub + "\" name=\"Operation\">");
	   out.println(" <input type=\"reset\" value=\"Reset\" name=\"reset\">");
	   out.println("</form>");
	   out.println("");
	   out.println("</body>");
	} // End PrintBody
	
	private void PrintBody (PrintWriter out)
	{
	   PrintBody(out, "", "", "");
	}
	
	private void PrintTail (PrintWriter out)
	{
	   out.println("");
	   out.println("</html>");
	} // End PrintTail

}
