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
	<h2>Delete a client</h2>
	<form action="/Music/servlet/DeleteClient" method="GET">
		<table>
			<tr>
				<td>Passport ID:</td>
					<td><input type="text" name="passport"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Delete"></td>
			</tr>
		</table>
	</form>
</body>
</html>
