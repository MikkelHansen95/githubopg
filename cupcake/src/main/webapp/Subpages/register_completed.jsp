<%-- 
    Document   : reg_completed
    Created on : 21-09-2017, 11:35:25
    Author     : GertLehmann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error page</title>
    </head>
    <body>
        
        <div>
            <h1>Succes</h1>
            <% String username = request.getParameter("username"); %>
            
            <h3>The user <%=username%> has been succesfully registered. 
            <br>Please login before you continue.</h3><br>
            
            <form method="get" action="login.jsp">
                <button type="submit">Go to Login</button>
            </form>

        </div>    </body>
</html>
