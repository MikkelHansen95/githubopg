<%-- 
    Document   : notEnoughMoney
    Created on : 21-09-2017, 21:42:37
    Author     : GertLehmann
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="entities.Orderline"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <div>
            <h1>Not enough cash!!</h1>

            <h3>You do not have enough cash for this order. 
                <br>Go back to Shopping Cart and make a new order.</h3><br>

            <br>
            <form method="get" action="shopCart.jsp">
                <button type="submit">Go back to Shopping Cart</button>
            </form>


        </div>


        <%

            ArrayList<Orderline> orderLines = new ArrayList();
            double totalPrice = 0;
            session.setAttribute("orderLines", orderLines);
            session.setAttribute("totalPrice", totalPrice);

        %>
    </body>
</html>
