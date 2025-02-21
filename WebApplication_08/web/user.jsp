<%-- 
    Document   : user
    Created on : Feb 13, 2025, 8:50:38 AM
    Author     : SideQuest
--%>

<%@page import="DTO.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
       UserDTO user =(UserDTO)request.getAttribute("user");
       %>
       <h1 color="blue">Welcome <%=user.getFullName()%></h1>
    </body>
</html>
