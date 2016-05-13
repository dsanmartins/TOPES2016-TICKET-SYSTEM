package org.floristan.servlet;

import java.io.IOException;

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

public class DeleteTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Storage storable = null; 
	private final static java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(StorageBean.class.getName());
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteTicketServlet() {
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


		int result = 0;
		String idTicket = request.getParameter("idTicket");
		int iTicket = Integer.parseInt(idTicket);
		
		try {
			
			result = storable.deleteTicket(iTicket);  

		} catch (Exception e) {
			e.printStackTrace ();
		}
		
		request.getSession().setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/dTicketR.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
}
