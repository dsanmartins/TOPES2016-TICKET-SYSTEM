package org.floristan.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.floristan.storable.Storage;
import org.floristan.storable.StorageBean;

/**
 * Servlet implementation class CreateSeatServlet
 */

public class UpdateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Storage storable = null; 
	private final static java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(StorageBean.class.getName());
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateClientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			InitialContext ctx = new InitialContext();
			storable = (Storage) ctx.lookup("java:app/Music/StorageBean");
		}catch (Exception e) {
			System.out.println("Problems:"+ e);
		}

		String firstname = request.getParameter("firstname");
		String surname = request.getParameter("surname");
		String mobilePhone = request.getParameter("mobile");
		String firstPhone = request.getParameter("firstPhone");
		String secondPhone = request.getParameter("secondPhone");
		String email = request.getParameter("email");
		String passport = request.getParameter("passport");
		String rg = request.getParameter("rg");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String cpf = request.getParameter("cpf");
		String borndate = request.getParameter("timepicker");

		Date f1=null;
		try {
			f1 = (new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(borndate));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			storable.updateClient(firstname, surname,
					mobilePhone,  firstPhone,  secondPhone,
					email,  passport,  rg,  address,
					city,  cpf, f1);

		} catch (Exception e) {
			e.printStackTrace ();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/uClientR.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
}
