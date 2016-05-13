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
	<form action="/Music/servlet/CreateClient" method="GET">
		<table>
			<tr>
				<td>First Name:</td>
				<td>
					<input type="text" name="firstname">
				</td>
			</tr>
			<tr>
				<td>Surname</td>
				<td><input type="text" name="surname"></td>
			</tr>
			<tr>
				<td>Mobile:</td>
				<td><input type="text" name="mobile"></td>
			</tr>
			<tr>
				<td>First Phone:</td>
				<td><input type="text" name="firstPhone"></td>
			</tr>
			<tr>
				<td>Second Phone:</td>
				<td><input type="text" name="secondPhone"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Passport:</td>
				<td><input type="text" name="passport"></td>
			</tr>
			<tr>
				<td>Rg:</td>
				<td><input type="text" name="rg"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td>Cpf:</td>
				<td><input type="text" name="cpf"></td>
			</tr>
			<tr>
				<td>Born date:</td>
				<td><input type="text" name="timepicker"  id="timepicker"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Create"></td>
			</tr>
		</table>
	</form>
</body>
</html>
