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
</head>
<body>
	<h2>Update the tax of a Seat Category </h2>
	<form action="/Music/servlet/UpdateCategory" method="GET">
		<table>
			<tr>
				<td>Seat Category:</td>
				<td>
					<input type="text" id="category" name="category">
				</td>
			</tr>
			<tr>
				<td>Tax::</td>
				<td><input type="text" id="tax" name="tax"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" id="submit" name="submit" value="Update"></td>
			</tr>
		</table>
	</form>
</body>
</html>
