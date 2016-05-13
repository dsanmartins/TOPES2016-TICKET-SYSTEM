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
<link rel="stylesheet"
	href="resources/css/jquery-ui-timepicker-addon.css">
<script type="text/javascript">
$(document).ready(function() {
	$('#timepicker').datetimepicker();
});	

function loadValues()
{
	$.ajax({
		type : 'GET',
		url : '/Music/servlet/LoadClient?passport='+ $('#passport').val(),
		success : function(data) {
			if (data.length != 0)
			{
				$('#lblMessage').attr('value','');
				var values = data.split("|");
				$('#firstname').val(values[0]);
				$('#surname').val(values[1]);
				$('#mobile').val(values[2]);
				$('#firstPhone').val(values[3]);
				$('#secondPhone').val(values[4]);
				$('#email').val(values[5]);
				$('#rg').val(values[6]);
				$('#address').val(values[7]);
				$('#city').val(values[8]);
				$('#cpf').val(values[9]);
				$('#timepicker').val(values[10]);
			}
			else
			{
				$('#lblMessage').attr('value','The Client does not exist!');
				$('#firstname').attr('value','');
				$('#surname').attr('value','');
				$('#mobile').attr('value','');
				$('#firstPhone').attr('value','');
				$('#secondPhone').attr('value','');
				$('#email').attr('value','');
				$('#rg').attr('value','');
				$('#address').attr('value','');
				$('#city').attr('value','');
				$('#cpf').attr('value','');
				$('#timepicker').attr('value','');
			}
		}
	});
	
}

</script>
</head>
<body>

	<h2>Update a Client</h2>
	<form action="/Music/servlet/UpdateClient" method="GET">
		<table>
	     	<tr>
				<td>Passport:</td>
				<td><input type="text" name="passport" id="passport" onblur="loadValues();"><input type="text" style="border: 0px none; " name="lblMessage" id="lblMessage" readonly>  </td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstname" id="firstname"></td>
			</tr>
			<tr>
				<td>Surname</td>
				<td><input type="text" name="surname" id="surname"></td>
			</tr>
			<tr>
				<td>Mobile:</td>
				<td><input type="text" name="mobile" id="mobile"></td>
			</tr>
			<tr>
				<td>First Phone:</td>
				<td><input type="text" name="firstPhone" id="firstPhone"></td>
			</tr>
			<tr>
				<td>Second Phone:</td>
				<td><input type="text" name="secondPhone" id="secondPhone"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" id="email"></td>
			</tr>
			<tr>
				<td>Rg:</td>
				<td><input type="text" name="rg" id="rg"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address" id="address"></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="city" id="city"></td>
			</tr>
			<tr>
				<td>Cpf:</td>
				<td><input type="text" name="cpf" id="cpf"></td>
			</tr>
			<tr>
				<td>Born date:</td>
				<td><input type="text" name="timepicker" id="timepicker"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form>
</body>
</html>
