<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*, java.io.*, java.net.*, java.util.jar.*, java.sql.Timestamp, java.text.*"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<title>Florestan System</title>
<script src="resources/js/jquery-2.0.3.js"></script>
<link rel="stylesheet" href="resources/css/menu_admin.css">

<script type="text/javascript">
	$(document).ready(function() {
		$("#idCSeat").click(function(e) {
			e.preventDefault();
			$("#someFrame").attr("src", $(this).attr("href"));
		});

		$("#idCMusicalEvent").click(function(e) {
			e.preventDefault();
			$("#someFrame").attr("src", $(this).attr("href"));
		});
		
		$("#idCClient").click(function(e) {
			e.preventDefault();
			$("#someFrame").attr("src", $(this).attr("href"));
		});

		$("#idUSeat").click(function(e) {
			e.preventDefault();
			$("#someFrame").attr("src", $(this).attr("href"));
		});
		
		$("#idUClient").click(function(e) {
			e.preventDefault();
			$("#someFrame").attr("src", $(this).attr("href"));
		});

		$("#idDSeat").click(function(e) {
			e.preventDefault();
			$("#someFrame").attr("src", $(this).attr("href"));
		});
		
		$("#idDClient").click(function(e) {
			e.preventDefault();
			$("#someFrame").attr("src", $(this).attr("href"));
		});

		$("#idCTicket").click(function(e) {
			e.preventDefault();
			$("#someFrame").attr("src", $(this).attr("href"));
		});

		$("#idCCancel").click(function(e) {
			e.preventDefault();
			$("#someFrame").attr("src", $(this).attr("href"));
		});

		$("#idLSeat").click(function(e) {
			e.preventDefault();
			$("#someFrame").attr("src", $(this).attr("href"));
		});
		
		$("#idLClient").click(function(e) {
			e.preventDefault();
			$("#someFrame").attr("src", $(this).attr("href"));
		});

		$("#idCCategory").click(function(e) {
			e.preventDefault();
			$("#someFrame").attr("src", $(this).attr("href"));
		});

		$("#idUCategory").click(function(e) {
			e.preventDefault();
			$("#someFrame").attr("src", $(this).attr("href"));
		});

		$("#idDCategory").click(function(e) {
			e.preventDefault();
			$("#someFrame").attr("src", $(this).attr("href"));
		});
		
	});

</script>

</head>

<%
	ServletContext app = getServletConfig().getServletContext();
	InputStream inputStream = application
			.getResourceAsStream("/META-INF/MANIFEST.MF");
	Manifest manifest = new Manifest(inputStream);
	Attributes atts = manifest.getMainAttributes();
	String[] values = atts.getValue("Implementation-Version").split(
			"\\-");
	long val = Long.parseLong(values[2]);
	Timestamp ts = new Timestamp(val);
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	String date = df.format(new Date(ts.getTime()));
%>

<body>
	<table>
		<tr>
			<td>


				<ul class="menu">

					<li><a id="Home" href="index.jsp">Home</a></li>

					<li><a href="#">Create</a>

						<ul>
						<li><a id="idCMusicalEvent" href="cMusicalEvent.jsp" class="new"
								>Musical Show</a></li>
								
							<li><a id="idCCategory" href="cCategory.jsp" class="new"
								>Seat Category</a></li>	
							<li><a id="idCSeat" href="cSeat.jsp" class="new"
								>Seat</a></li>
							<li><a id="idCClient" href="cClient.jsp" class="new"
								>Client</a></li>
				
						</ul>
					</li>
					
						<li><a href="#">Update</a>

						<ul>
							<li><a id="idUCategory" href="uCategory.jsp" class="new"
								>Seat Category</a></li>
							<li><a id="idUSeat" href="uSeat.jsp" class="new"
								>Seat</a></li>
							<li><a id="idUClient" href="uClient.jsp" class="new"
								>Client</a></li>
				
						</ul>
					</li>
					
					<li><a href="#">Delete</a>

						<ul>
							<li><a id="idDCategory" href="dCategory.jsp" class="new"
								>Seat Category</a></li>
							<li><a id="idDSeat" href="dSeat.jsp" class="new"
								>Seat</a></li>
							<li><a id="idDClient" href="dClient.jsp" class="new"
								>Client</a></li>
				
						</ul>
					</li>
					

					
					<li><a href="#">Tickets</a>

						<ul>
							<li><a id="idCTicket" href="cTicket.jsp" class="new"
								>Sell a Ticket</a></li>
							<li><a id="idCCancel" href="cCancel.jsp" class="new"
								>Cancel a Ticket</a></li>
				
						</ul></li>

					<li><a href="#">Reports</a>

						<ul>
							<li><a id="idLSeat" href="lSeat.jsp" class="new"
								>Tickets Sold</a></li>
							<li><a id="idLClient" href="lClient.jsp" class="new"
								>List of Clients</a></li>
				
						</ul></li>

				</ul>
			</td>
		</tr>
		<tr>
			<td><iframe style="border: none;" name="someFrame" id="someFrame" width="1300"
					height="550">Hola Mundo</iframe></td>
		</tr>
	</table>
	<table>
		<tr>
			<td>Florestan software versión: <b>0.1</b>, compiled date: <b><%=date%></b>.
			</td>
		</tr>
	</table>
</body>
</html>