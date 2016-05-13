package org.floristan.servlet;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.floristan.model.SeatCategory;
import org.floristan.storable.Storage;
import org.floristan.storable.StorageBean;

/**
 * Servlet implementation class CreateSeatServlet
 */

public class CreateSeatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Storage storable = null; 
	private final static java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(StorageBean.class.getName());
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateSeatServlet() {
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

		LOGGER.info(request.getParameter("number"));
		LOGGER.info(request.getParameter("situation"));
		
		int result = 0;
		try {
			String number = request.getParameter("number");
			String situation = request.getParameter("situation");
			String select = request.getParameter("select");
			String seatCategory = request.getParameter("seatCategory");
			
			int iNumber = Integer.parseInt(number);
			int iSituation = Integer.parseInt(situation);
			int idMusicalEvent = Integer.parseInt(select);
			int iCategory = Integer.parseInt(seatCategory);
			

			if(Integer.parseInt(number) >= 1) {
				int seat = storable.getSeatNumber(iNumber, idMusicalEvent);
				if (seat == 0)
				{
					storable.createSeat(iNumber,iSituation, idMusicalEvent, iCategory);
					result = 1;  
				}
				else
					result = seat;	
			}
		} catch (Exception e) {
			e.printStackTrace ();
		}
		

		request.getSession().setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/cSeatR.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}
}
