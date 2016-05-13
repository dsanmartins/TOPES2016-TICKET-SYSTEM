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
if ( result == 1 )
{ 
%>
  <h2>A new seat was created.</h2>
  
<%
    }
    else
    {
%>
    <h2>ATTENTION: The seat was created previously!</h2>
<%
    }
%>  
  
  
</body>
</html>
