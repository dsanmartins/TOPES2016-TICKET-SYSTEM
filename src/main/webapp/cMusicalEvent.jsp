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
$(document).ready(function() {
	$('#timepicker').datetimepicker();
});	
</script>
</head>
<body>
  <h2>Create a new Musical Show</h2>
  <form action="/Music/servlet/CreateMusicalEvent" method="GET">
    <table>
    <tr> <td>Event Name:</td><td> <input type="text" name="eventName"></td></tr>
     <tr> <td> Date and Time of Event: </td><td>  <input type="text" name="timepicker" id="timepicker" value=""/></td></tr>
     <tr> <td> Description: </td><td>  <textarea name="description" rows="4" cols="80" ></textarea></td></tr>
     <tr> <td></td> <td> <input type="submit" value="Create"> </td></tr>
    </table>
  </form>
</body>
</html>
