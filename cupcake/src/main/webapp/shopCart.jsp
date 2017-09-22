<%-- 
    Document   : shopCart
    Created on : 21-09-2017, 09:27:31
    Author     : Strom
--%>

<%@page import="entities.Orderline"%>
<%@page import="entities.Bottom"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Topping"%>
<%@page import="java.util.List"%>
<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            .CShop {
                margin-left: 5px;
            }
            .DD{
                float: left; 
                width: 150px;
                height: 75px;
                margin-left: 5px;
                margin-bottom: 5px;
            }
            input[type=text] {
                width: 80%;
            }
            .logout {
                margin-top: 15px;
                margin-left: 5px;
            }
            .brugerP{
                margin-left: 10px;
                margin-bottom: 10px;
            }
            input[type=submit] {
                margin-top: 15px;
            }
            .checkout{
                margin-left: 475px;
                margin-top: 100px;
            }


        </style>

    </head>
    <body>
        <h1>Welcome to the Cupcake shop</h1>

        <%
            User user = (User) (session.getAttribute("user"));
            String username = user.getName();
            double balance = user.getBalance();
        %>
        <div class='brugerP'>
            Hello <%=username%> - your balance is : <%=balance%>
        </div>

        <%
            ArrayList<Topping> toppingList = (ArrayList) (session.getAttribute("toppingList"));
            ArrayList<Bottom> bottomList = (ArrayList) (session.getAttribute("bottomList"));
            ArrayList<Orderline> orderlineList = (ArrayList) (session.getAttribute("orderLines"));
            double totalPrice = (double) (session.getAttribute("totalPrice"));
        %>



        <div class ="CShop">

            <form name="CupcakeSelect" action="GenerateOrderLine" method="get">
                <div class="DD">
                    Bottom <br>
                    <select name="bottom">
                        <% for (int b = 0; b < bottomList.size(); b++) {
                                String navn = bottomList.get(b).getName() + "  " + Double.toString(bottomList.get(b).getPrice());

                                out.println("<option value=" + (b + 1) + ">" + navn + " </option>");

                            }
                        %>
                    </select>
                </div>
                <div class="DD">
                    Topping <br>
                    <select name="topping">
                        <% for (int t = 0; t < toppingList.size(); t++) {
                                String navn = toppingList.get(t).getName() + "  " + Double.toString(toppingList.get(t).getPrice());

                                out.println("<option value=" + (t + 1) + ">" + navn + " </option>");

                            }
                        %>
                    </select>
                </div>

                <div class="DD">
                    Quantity <br>
                    <input type="text" name="quantity" value="0">
                </div>

                <input type="submit" name="submit" value="Add">


            </form>
            <br><br><br>
            <div class="CShop">
                <br>
                <% for (Orderline ol : orderlineList) {%>
                Bottom = <b><%=ol.getBottom().getName()%></b> * 
                Topping = <b><%=ol.getTopping().getName()%></b> * 
                Quantity = <b><%=ol.getQuantity()%></b> * 
                Price = <b><%=ol.getPrice()%></b>
                <br>
                <% }%>
                <br>Total price : <b><%=totalPrice%></b>

            </div>

            <div class="logout">
                <form method="get" action="GenerateOrder">
                    <input type="submit" name="submit" value="Check out">
                </form>
            </div>



            <div class="logout">
                <form method="get" action="customerPage.jsp">
                    <input type="submit" name="submit" value="Show previous orders">
                </form>
            </div>

            <div class="logout">
                <form method="get" action="login.jsp">
                    <input type="submit" name="submit" value="Log out">
                </form>
            </div>



        </div>



    </body>
</html>
