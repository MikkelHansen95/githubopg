<%-- 
    Document   : orderFinished
    Created on : 21-09-2017, 19:34:30
    Author     : GertLehmann
--%>

<%@page import="entities.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            ArrayList<Topping> toppingList = (ArrayList) (session.getAttribute("toppingList"));
            ArrayList<Bottom> bottomList = (ArrayList) (session.getAttribute("bottomList"));
            ArrayList<Orderline> orderlineList = (ArrayList) (session.getAttribute("orderLines"));
            double totalPrice = (double) (session.getAttribute("totalPrice"));
            User user = (User) (session.getAttribute("user"));
            Order newOrder = (Order) request.getAttribute("newOrder");
        %>

        <div>
            <h1>Order Finished!</h1>

            <h3>Order number : <%=newOrder.getOrder_id()%>
                <br>User :  <%=user.getName()%>
                <br>Date :  <%=newOrder.getDate()%>

                <br><br></h3>

            <% for (Orderline ol : orderlineList) {%>
            Bottom = <b><%=ol.getBottom().getName()%></b> * 
            Topping = <b><%=ol.getTopping().getName()%></b> * 
            Quantity = <b><%=ol.getQuantity()%></b> * 
            Price = <b><%=ol.getPrice()%></b>
            <br>
            <% }%>
            <h3><br>Total price : <b><%=totalPrice%></b>

                <br><br>
                Your cupcakes has been shipped.
                <br>Thanks for shopping at our webshop.</h3><br>

            
            <form method="get" action="shopCart.jsp">
                <button type="submit">Go back to Shopping Cart</button>
            </form>

            <div >
                <form method="get" action="login.jsp">
                    <input type="submit" name="submit" value="Log out">
                </form>
            </div>

        </div>


        <%
            ArrayList<Orderline> orderLines = new ArrayList();
            totalPrice = 0;
            session.setAttribute("orderLines", orderLines);
            session.setAttribute("totalPrice", totalPrice);

        %>
    </body>
</html>
