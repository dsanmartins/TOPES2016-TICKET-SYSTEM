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
String situation = (String) session.getAttribute( "situation" );
if (result >= 1 )
{ 
%>
  <h2>The seat <%=Integer.toString(result)%>  was updated <% if (Integer.parseInt(situation) == 1) %> unavailable <% else %> available.</h2>
  
<%
    }
    else
    {
%>
    <h2>ATTENTION: The seat does not exist!</h2>
<%
    }
%>  
  
  
</body>
</html>
