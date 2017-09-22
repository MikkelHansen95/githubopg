<%-- 
    Document   : errorpage
    Created on : 21-09-2017, 08:49:22
    Author     : Strom
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
            <h1>Error!</h1>

            <h2>Username or password is incorrect 
            <br>or user does not exits.</h2><br>

            <form method="get" action="login.jsp">
                <button type="submit">Go to Login</button>
            </form>
            <br>
            <form method="get" action="registration.jsp">
                <button type="submit">Register new user</button>
            </form>

        </div>
    </body>
</html>
