package org.floristan.servlet;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import org.floristan.model.Client;
import org.floristan.model.MusicalEvent;
import org.floristan.model.Seat;
import org.floristan.model.TicketSale;
import org.floristan.report.Template;
import org.floristan.storable.Storage;
import org.floristan.storable.StorageBean;

/**
 * Servlet implementation class CreateSeatServlet
 */

public class CreateBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Storage storable = null; 
	private final static java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(StorageBean.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateBillServlet() {
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

		String idTicketMusical = request.getParameter("result");
		TicketSale ts = storable.getTicketSale(Integer.parseInt(idTicketMusical));
		Client c = ts.getClient();

		String reportName =  "proof_purchase_"+c.getPassport();
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=" + reportName + ".pdf");
		response.setHeader("Set-Cookie", "fileDownload=true; path=/");
		OutputStream out = response.getOutputStream();
		
		DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String f1 = dateFormat1.format(date);
		String f2 = dateFormat2.format(date);
		
		// Start reporting 
		JasperReportBuilder subreport1 = report();

		subreport1
		.setTemplate(Template.reportTemplate1)
		.setShowColumnTitle(true)
		.columns(
				col.column("ID","id",type.integerType()).setHorizontalAlignment(HorizontalAlignment.CENTER),
				col.column("Show Name","show",type.stringType()).setHorizontalAlignment(HorizontalAlignment.CENTER),
				col.column("Show Date", "date", type.dateType()).setHorizontalAlignment(HorizontalAlignment.CENTER),
				col.column("Passport", "passport", type.stringType()).setHorizontalAlignment(HorizontalAlignment.CENTER),
				col.column("Name", "name", type.stringType()).setHorizontalAlignment(HorizontalAlignment.CENTER),
				col.column("Seat", "seat", type.integerType()).setHorizontalAlignment(HorizontalAlignment.CENTER),
				col.column("Payment", "payment", type.stringType()).setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(stl.style().setForegroundColor(Color.RED)),
				col.column("Total", "total", type.integerType()).setHorizontalAlignment(HorizontalAlignment.CENTER)
				)
				.title(Template.head(f1,f2))
				.setDataSource(createDataSource(ts));

		JasperReportBuilder report = report().title(cmp.verticalList(cmp.subreport(subreport1))).pageFooter(Template.footerComponent1);


		try {
			report.toPdf(out);
		} catch (DRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private JRDataSource createDataSource(TicketSale ts ) 
	{
		Client c = ts.getClient();
		Seat s = ts.getSeat();
		MusicalEvent me = s.getMusicalEvent();
		int tax = storable.getTaxFromCategory(s);
		int price = ts.getPrice();
		int total = tax + price;
		
		DRDataSource dataSource = new DRDataSource("id","show","date", "passport", "name", "seat", "payment", "total");
		dataSource.add(ts.getId(),me.getEventName(),me.getEventDate(),c.getFirstname() + " "+c.getSurname() ,c.getPassport(), s.getNumberSeat(),ts.getPaidForm().toUpperCase(), total);
		return dataSource;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
