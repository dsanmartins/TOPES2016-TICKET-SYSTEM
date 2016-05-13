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
 * Servlet implementation class CreateUser
 */

public class CreateTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Storage storable = null; 
	/**

    /**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateTicketServlet() {
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

		String musicalEvent = request.getParameter("select");
		String seat = request.getParameter("seats");
		String client = request.getParameter("client");
		String price = request.getParameter("price");
		String payment = request.getParameter("payment");
		String saleDate = request.getParameter("saleDate");

		int iPrice = 0;
		if (payment.equals("reservation"))
			iPrice = 0;
		else
			iPrice = Integer.parseInt(price);

		int iMusicalEvent = Integer.parseInt(musicalEvent);
		int iSeat = Integer.parseInt(seat);
		int iClient =  Integer.parseInt(client);

		Date f1 = null;
		try {
			f1 = (new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(saleDate));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int result = storable.createTicket(iMusicalEvent,iSeat, iPrice, f1, iClient,payment);
		request.getSession().setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/cTicketR.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
