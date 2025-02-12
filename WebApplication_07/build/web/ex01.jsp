<%-- 
    Document   : ex01
    Created on : Feb 10, 2025, 7:38:18 AM
    Author     : SideQuest
--%>


<%@page import="java.lang.Math"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           <%! int a = 9; int b = 8;%>
           <%
           double c;
           c = Math.sqrt(a) + Math.sqrt(b);
           %>
           Result: <%=a%> <%=b%> = <span style="color:red"><%=c%></span>
    </body>
</html>
