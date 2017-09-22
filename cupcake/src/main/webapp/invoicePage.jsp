<%-- 
    Document   : invoicePage
    Created on : Sep 21, 2017, 2:47:31 PM
    Author     : Christian
--%>

<%@page import="java.util.List"%>
<%@page import="entities.Orderline"%>
<%@page import="entities.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
                
        <h1>Hello World! invoice</h1>
        
        <%
            int orderid = (int) session.getAttribute("orderId");
            String username = (String) session.getAttribute("username");
            String date = (String) session.getAttribute("date");
            List<Orderline> orderlineList = (List<Orderline>) session.getAttribute("orderLines");
            int totalPrice = (int) session.getAttribute("totalPrice");
            
            
        %>
        <p>Order id:</p>
        <%=orderid%>
        
        <p>Username: </p>
         <%=username%>
         
         <p>Date: </p>
         <%=date%>
         
         <p>Total Price:</p>
         <%=totalPrice%>
         
         <p>Orderlines:</p>
         <%
            int i = 1;
            for (Orderline o: orderlineList) {
                out.println("Orderline number: " + i);
                out.println("<br>");
                out.println("priceForwholeLine: ");
                out.println(o.getPrice());
                out.println("quantity: ");
                out.println(o.getQuantity());
                out.println("<br>");
                out.println("&emsp;");
                out.println(o.getBottom().getName());
                out.println("price: ");
                out.println(o.getBottom().getPrice());
                out.println("<br>");
                out.println("&emsp;");
                out.println(o.getTopping().getName());
                out.println("price: ");
                out.println(o.getTopping().getPrice());
                i++;
                out.println("<br>");
                out.println("<br>");
            }
         
         %>
        
         
    </body>
</html>
