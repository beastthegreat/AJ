package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.VotersDaoImpl;

import pojos.Voters;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/validate")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VotersDaoImpl dao;

	@Override
	public void init() throws ServletException {
		// dao inst
		try {
			dao = new VotersDaoImpl();
		} catch (Exception e) {
			// centralized err handling approach in servlet
			// catch exc -- wrap it in SE --re throw to WC
			throw new ServletException("err in init", e);
		}
	}
	@Override
	public void destroy() {
		if (dao != null)
			try {
				dao.cleanUp();
			} catch (Exception e) {
				throw new RuntimeException("err in destroy", e);
			}
	}

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set cont type
		response.setContentType("text/html");
		// open PW
		try (PrintWriter pw = response.getWriter()) {
			// read req params
			String emailid = request.getParameter("emailid");
			String passwd = request.getParameter("passwd");
			// invoke DAO's method for validation
			Voters c=dao.validateVoter(emailid, passwd);
			if(c == null)
				pw.print("<h4>Invalid Login , Pls <a href=login.html>Retry</a></h4>");
			else
			{
				pw.print("from login page....");//will not be sent to clnt browser
		//		pw.flush(); un comment to check the exc.
			/*	pw.print("<h4>Login Successful<br>");
				pw.print("Customer details "+c);*/
				//redirect clnt to details page
				//create a cookie  to hold customer dtls
				Cookie c1=new Cookie("cust_details",c.toString());
				//add d cookie in resp hdr
				response.addCookie(c1);
				response.sendRedirect("category");
			}
		} catch (Exception e) {
			throw new ServletException("err in do-get",e);
		}
	}

}
