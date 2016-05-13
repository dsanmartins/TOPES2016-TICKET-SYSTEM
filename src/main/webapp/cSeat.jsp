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
	$(document).ready(function() {

				$.ajax({
					type : 'GET',
					url : '/Music/servlet/LoadMusicalEvent',
					success : function(data) {
						
						if (data.length > 0) {
							$('#submit').prop('disabled', false);
							str = '<SELECT id="select" name="select">';
							var line = data.split("|");
							for (var i = 0; i < line.length; i++) {
								var value = line[i].split(",")[0];
								var name = line[i].split(",")[1];
								str = str + "<OPTION VALUE=" + value +">"
										+ name + "</OPTION>";
							}
							$("#space").replaceWith(str);
						}
						else
							$('#submit').prop('disabled', true);
					},
					  error: function(){
						  $('#submit').prop('disabled', true);
					  }
				});
	
				$.ajax({
					type : 'GET',
					url : '/Music/servlet/LoadSeatCategories',
					success : function(data) {
						
						if (data.length > 0) {
							$('#submit').prop('disabled', false);
							str = '<SELECT id="seatCategory" name="seatCategory">';
							var line = data.split("|");
							for (var i = 0; i < line.length; i++) {
								var value = line[i].split(",")[0];
								var name = line[i].split(",")[1];
								str = str + "<OPTION VALUE=" + value +">"
										+ name + "</OPTION>";
							}
							$("#category").replaceWith(str);
						}
						else
							$('#submit').prop('disabled', true);
					},
					  error: function(){
						  $('#submit').prop('disabled', true);
					  }
				});
});
</script>
</head>
<body>
	<h2>Create a new seat</h2>
	<form action="/Music/servlet/CreateSeat" method="GET">
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
				<td>Situation:</td>
				<td><input type="text" name="situation" value="0" readonly></td>
			</tr>
			<tr>
				<td>Category:</td>
				<td><div id="category"></div></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" id="submit" name="submit"
					value="Create"></td>
			</tr>
		</table>
	</form>
</body>
</html>
