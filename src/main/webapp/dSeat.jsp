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
<script type="text/javascript">
	$(document).ready(
			function() {
				$.ajax({
					type : 'GET',
					url : '/Music/servlet/LoadMusicalEvent',
					success : function(data) {
						str = '<SELECT id="select" name="select">';
						var line = data.split("|");
						for (var i = 0; i < line.length; i++) {
							var value = line[i].split(",")[0];
							var name = line[i].split(",")[1];
							str = str + "<OPTION VALUE=" + value +">" + name
									+ "</OPTION>";
						}
						$("#space").replaceWith(str);
					}
				});
			});
</script>
</head>
<body>
	<h2>Delete a seat</h2>
	<form action="/Music/servlet/DeleteSeat" method="GET">
		<table>
			<tr>
				<td>Musical Show:</td>
				<td>
					<div id="space"></div>
				</td>
			</tr>
			<tr>
				<td>Number:</td>
				<td><input type="text" name="number"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Delete"></td>
			</tr>
		</table>
	</form>
</body>
</html>
