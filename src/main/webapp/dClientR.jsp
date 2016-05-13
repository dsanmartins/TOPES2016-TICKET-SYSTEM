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
String result = (String) session.getAttribute( "result" );
if (result != "0" )
{ 
%>
  <h2>The seat client was deleted.</h2>
  
<%
    }
    else
    {
%>
    <h2>ATTENTION: The client does not exist!</h2>
<%
    }
%>  
  
  
</body>
</html>
