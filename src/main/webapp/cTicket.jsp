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
	$(document).ready(
			function() {

				$('#saleDate').datetimepicker();
				$("#price").val('0');
				$("#price").prop("disabled", true);
				var newOptions = {};
				$.ajax({
					type : 'GET',
					url : '/Music/servlet/LoadMusicalEvent',
					success : function(data) {

						if (data.length > 0) {
							$('#submit').prop('disabled', false);
							var line = data.split("|");

							for (var i = 0; i < line.length; i++) {
								var value = line[i].split(",")[0];
								var name = line[i].split(",")[1];
								newOptions[value] = name;
							}
							var $el = $("#select");
							$el.empty(); // remove old options
							$.each(newOptions, function(value,key) {
							  $el.append($("<option></option>").attr("value", value).text(key));
							});
							
						} else {
							$('#submit').prop('disabled', true);
						}
					},
					error : function() {
						$('#submit').prop('disabled', true);
					}
				});

				$.ajax({
					type : 'GET',
					url : '/Music/servlet/LoadClients',
					success : function(data) {

						if (data.length > 0) {
							$('#submit').prop('disabled', false);
							str = '<SELECT id="client" name="client"  >';
							var line = data.split("|");
							for (var i = 0; i < line.length; i++) {
								var value = line[i].split(",")[0];
								var name = line[i].split(",")[1];
								str = str + "<OPTION VALUE=" + value +">"
										+ name + "</OPTION>";
							}
							str = str + '</SELECT>'
							$("#clients").replaceWith(str);
						} else
							$('#submit').prop('disabled', true);
					},
					error : function() {
						$('#submit').prop('disabled', true);
					}
				});

			});

	function getSeats() {

		var newOptions = {};
		var option = $('<option></option>').attr("value", "option value").text("Text");
		$("#seats").empty().append(option);
		$.ajax({
			type : 'GET',
			url : '/Music/servlet/LoadSeats?musicalEvent=' + $("#select option:selected").val(),
			success : function(data) {

				if (data.length > 0) {
					$('#submit').prop('disabled', false);
					var line = data.split("|");
					for (var i = 0; i < line.length; i++) {
						var value = line[i].split(",")[0];
						var name = line[i].split(",")[1];
						newOptions[value] = name;
					}
					
					var $el = $("#seats");
					$el.empty(); // remove old options
					$.each(newOptions, function(value,key) {
					  $el.append($("<option></option>").attr("value", value).text(key));
					});
					
					
				} else {
					$('#submit').prop('disabled', true);
				}
			},
			error : function() {
				$('#submit').prop('disabled', true);
			}
		});
	}

	function verifyCheckBox(p) {
		if (p.id == 'payment1') {
			$("#payment1").prop("checked", true);
			$("#payment2").prop("checked", false);
			$("#payment3").prop("checked", false);
			$("#payment4").prop("checked", false);
			$("#price").val('');
			$("#price").prop("disabled", false);
		} else {
			if (p.id == 'payment2') {
				$("#payment2").prop("checked", true);
				$("#payment1").prop("checked", false);
				$("#payment3").prop("checked", false);
				$("#payment4").prop("checked", false);
				$("#price").val('');
				$("#price").prop("disabled", false);
			} else {
				if (p.id == 'payment3') {
					$("#payment3").prop("checked", true);
					$("#payment1").prop("checked", false);
					$("#payment2").prop("checked", false);
					$("#payment4").prop("checked", false);
					$("#price").val('');
					$("#price").prop("disabled", false);
				} else {
					if (p.id == 'payment4') {
						$("#payment4").prop("checked", true);
						$("#payment1").prop("checked", false);
						$("#payment2").prop("checked", false);
						$("#payment3").prop("checked", false);
						$("#price").val('0');
						$("#price").prop("disabled", true);
					}
				}
			}
		}

	}
</script>
</head>
<body>

	<h2>Create a Sale</h2>
	<form action="/Music/servlet/CreateTicket" method="GET">
		<table>
			<tr>
				<td>Musical Show:</td>
				<td><SELECT id="select" name="select" onchange="getSeats()";>
				</SELECT></td>
			</tr>
			<tr>
				<td>Available Seats:</td>
				<td>
					<SELECT id="seats" name="seats" > </SELECT>
				</td>
			</tr>
			<tr>
				<td>Client:</td>
				<td><div id="clients"></div></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" id="price" name="price"></td>
			</tr>
			<tr>
				<td>Paid Form /Reservation:</td>
				<td><input type="checkbox" id="payment1" name="payment"
					value="credit" onclick="verifyCheckBox(this)"> Credit Card<br>
					<input type="checkbox" id="payment2" name="payment" value="debit"
					onclick="verifyCheckBox(this)"> Debit Card<br> <input
					type="checkbox" id="payment3" name="payment" value="cash"
					onclick="verifyCheckBox(this)"> Cash<br> <input
					type="checkbox" id="payment4" name="payment" value="reservation"
					onclick="verifyCheckBox(this)" checked> Reservation<br>
				</td>
			</tr>
			<tr>
				<td>Sale or Reservation Date:</td>
				<td><input type="text" id="saleDate" name="saleDate"></td>
			</tr>
			<tr>
				<td>Cancel Date:</td>
				<td><input type="text" name="cancelDate" value="" readonly></td>
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
