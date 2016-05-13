<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="javax.naming.*,
                 java.text.*,
                 java.util.*,
                 org.floristan.model.*,
                 org.floristan.storable.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
<script src="resources/js/jquery-2.0.3.js"></script>
<script src="resources/js/jquery-ui-1.10.3.custom.js"></script>
<script src="resources/js/jquery-ui-timepicker-addon.js"></script>
<link rel="stylesheet" href="resources/css/jquery-ui-1.10.3.custom.css">
<link rel="stylesheet" href="resources/css/jquery-ui-timepicker-addon.css">
<script type="text/javascript">

function getCreateTicket()
{
	$.ajax({
		type : 'POST',
		url : '/Music/servlet/CreateBillServlet?musicalEvent='+$( "#select option:selected" ).val(),
		success : function(data) {
			
			if (data.length > 0) {
				$('#submit').prop('disabled', false);
				str = '<SELECT id="seat" name="seat" >';
				var line = data.split("|");
				for (var i = 0; i < line.length; i++) {
					var value = line[i].split(",")[0];
					var name = line[i].split(",")[1];
					str = str + "<OPTION VALUE=" + value +">"
							+ name + "</OPTION>";
				}
				str = str + '</SELECT>'
				$("#seats").replaceWith(str);
			}
			else
			{
				$('#submit').prop('disabled', true);
			}
		},
		  error: function(){
			  $('#submit').prop('disabled', true);
		  }
	});
}


</script>
</head>
<body>

<%
int result = (Integer) session.getAttribute( "result" );
if ( result == 0 )
{ 
%>
  <h2>The client already bought a ticket! </h2>
  
<%
    }
    else
    {
%>
    <h2>Thank you for buying a ticket!, please download your ticket <a href="/Music/servlet/CreateBill?result=<c:out value="${result}"/>">HERE</a>. </h2>
<%
    }
%>  
  
  
</body>
</html>
