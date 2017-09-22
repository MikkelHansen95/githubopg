<%-- 
    Document   : invoice
    Created on : Sep 21, 2017, 1:46:19 PM
    Author     : Christian
--%>

<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="entities.Order"%>
<%@page import="java.util.List"%>
<%@page import="Mapper.OrderMapper"%>
<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! her er dine tidl. ordre</h1>
        <%
            User user = (User) (session.getAttribute("user"));
            String username = user.getName();
            double balance = user.getBalance();
            OrderMapper om = new OrderMapper();
            List<Order> orderList = 
                    om.getOrdersByUserId(user);
                    
        %>
        <div class='brugerP'>
            Hello <%=username%> - your balance is : <%=balance%>
        </div>
        
        <br>
        
        <div class='brugerP'>
            Hello <%=username%> - here are your previous orders : 
            <%=orderList%>
        </div>
        
        <br>
        
        <div class='brugerP'>
            Hello <%=username%> - orders version 2 : 
            <br>
            <%
                if (orderList.size() > 0) {
                    Collections.sort(orderList, new Comparator<Order>() {
                        @Override
                        public int compare(final Order object1, final Order object2) {
                            return object1.getDate().compareTo(object2.getDate());
                        }
                    });
                }              
                
                String output = "";
                output = output+"<p>";
                for (Order o: orderList) {
                    
                    out.println(
                    "<form action="+
                    "\""+ "ShowEachOrder"+"\""+
                    " method="+
                    "\""+ "POST"+"\""+
                    ">" +
                        
                    "<input type="+
                    "\""+ "hidden"+"\""+
                    " name= " +
                    "\""+"user"+"\""+
                    " value=" +
                    "\""+ 
                    user.getUser_id() +
                    "\""+                                
                    ">"    +   
                            
                    "<input type="+
                    "\""+ "hidden"+"\""+
                    " name= " +
                    "\""+"order"+"\""+
                    " value=" +
                    "\""+ 
                    o.getOrder_id()+
                    "\""+                                
                    ">"    +           
                            
                    " <input type=" +
                    "\""+ "submit"+"\""+
                    " name="+
                    "\""+ "submit"+"\""+
                    " value=" +
                    "\""+ "Show Order"+"\""+
                    ">" +
                            
                    "</form>"
                    
                    );
                }
                
                    /*
                    
                    "<input type="+
                    "\""+ "hidden"+"\""+
                    " name= " +
                    "\""+"login"+"\""+
                    " value=" +
                    "\""+ "true"+"\""+                                
                    ">"    +   
                */
            %>
            <br>
            
            
        <form action="ShowEachOrder" method="POST">  
            <input type="submit" name="submit" value="Show Order">
        </form>
             
        </div>
        
        
        
        <br>
        <form method="get" action="index.html">
            <button type="submit">Go to index</button>
        </form>
    </body>
</html>
