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

%>
  <h2>The client <%=result%> was created.</h2>
   
  
</body>
</html>
