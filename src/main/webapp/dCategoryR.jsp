<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="javax.naming.*,
                 java.text.*,
                 java.util.*,
                 org.floristan.model.*,
                 org.floristan.storable.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<body>

<%
int result = (Integer) session.getAttribute( "result" );

if (result == 1) 
{
%>

  <h2>The Seat Category was deleted.</h2>

<%
}
else
{
%>  
 
   <h2>The Seat Category does not exist.</h2>
   
<%
}

%>     
</body>
</html>
