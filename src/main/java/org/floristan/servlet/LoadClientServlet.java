package org.floristan.servlet;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.floristan.model.Client;
import org.floristan.storable.Storage;

/**
 * Servlet implementation class LoadMusicalEventServlet
 */
public class LoadClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Storage storable = null; 
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadClientServlet() {
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

		String passport = request.getParameter("passport");
		String var = "";

		Client client = storable.getClient(passport);
		if (client != null)
			var = client.getFirstname()+"|"+client.getSurname()+"|"+client.getMobilePhone()+"|"+
				  client.getFirstPhone()+"|"+client.getSecondPhone()+"|"+client.getEmail()+"|"+client.getRg()+"|"+
				  client.getAddress()+"|"+client.getCity()+"|"+client.getCpf()+"|"+client.getBornDate();


		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(var);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
