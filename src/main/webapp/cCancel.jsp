<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page
	import="javax.naming.*,
                 java.text.*,
                 java.util.*,
                 org.floristan.model.*,
                 org.floristan.storable.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
<head>
<script src="resources/js/jquery-2.0.3.js"></script>
<script src="resources/js/jquery-ui-1.10.3.custom.js"></script>
<script src="resources/js/jquery-ui-timepicker-addon.js"></script>
<link rel="stylesheet" href="resources/css/jquery-ui-1.10.3.custom.css">
<link rel="stylesheet" href="resources/css/jquery-ui-timepicker-addon.css">
<script type="text/javascript">
$(document).ready(function() {
	$('#timepicker').datetimepicker();
});	
</script>
</head>
<body>

	<h2>Create a new Client</h2>
	<form action="/Music/servlet/DeleteTicket" method="GET">
		<table>
			<tr>
				<td>Ticket ID:</td>
				<td>
					<input type="text" name="idTicket">
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Delete"></td>
			</tr>
		</table>
	</form>
</body>
</html>
