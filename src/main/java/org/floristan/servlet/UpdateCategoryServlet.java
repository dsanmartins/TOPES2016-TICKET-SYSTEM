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

public class UpdateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Storage storable = null; 
	/**

    /**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCategoryServlet() {
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
		String category = request.getParameter("category");
		String tax = request.getParameter("tax");
	
		int iTax = Integer.parseInt(tax);
		
		try {
			result = storable.updateCategory(category, iTax);
		} catch (Exception e) {
			e.printStackTrace ();
		}

		request.getSession().setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/uCategoryR.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
