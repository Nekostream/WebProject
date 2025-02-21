<%-- 
    Document   : login
    Created on : Feb 13, 2025, 8:16:21 AM
    Author     : SideQuest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login-Welcome</title>
    </head>
    <body>
        <form action="MainController" method="post">
            <input type="hidden" name ="action" value="LOGIN"/>
           UserID:   <input type ="text" name="strUserID"/> <br/>
           Password:<input type="password" name ="strPassword"/><br/>
            <input  type="submit" value="Login"/>
        </form>
    </body>
</html>
