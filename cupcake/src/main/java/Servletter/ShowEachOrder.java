/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servletter;

import Mapper.OrderMapper;
import Mapper.UserMapper;
import entities.Order;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Christian
 */
@WebServlet(name = "ShowEachOrder", urlPatterns = {"/ShowEachOrder"})
public class ShowEachOrder extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String carryInfo1 = request.getParameter("user");
        String carryInfo2 = request.getParameter("order");
        UserMapper userMap = new UserMapper();
        OrderMapper orderMap = new OrderMapper();
        User currentUser = userMap.getUserByID(Integer.parseInt(carryInfo1));
        //nedenstående fylder meget men jeg er lidt træt nu.
        List<Order> currentOrderList =  orderMap.getOrdersByUserId(currentUser);
        Order currentOrder = null;
        for (Order o: currentOrderList) {
            if (o.getOrder_id() == Integer.parseInt(carryInfo2)) {
                currentOrder = o;
            }
        }
        
        if (currentOrder != null) {
            HttpSession session = request.getSession();
                session.setAttribute("orderId", currentOrder.getOrder_id());
                session.setAttribute("username", currentOrder.getUser().getName());
                session.setAttribute("date", currentOrder.getDate());
                session.setAttribute("orderLines", currentOrder.getOrderlines());
                session.setAttribute("totalPrice", currentOrder.getTotal_price());

                request.getRequestDispatcher("invoicePage.jsp")
                        .forward(request, response);
        }
        
        //Order currentOrder = new Order(Integer.parseInt(carryInfo));
        
        /*
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowEachOrder</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShowEachOrder at " + request.getContextPath() + "</h1>");
            out.println("<p>");
            out.println("hello: ");
            out.println("</p>");
            out.println("<p>");
            out.println(currentUser);
            out.println("</p>");
            out.println("<p>");
            out.println(currentOrder);
            out.println("</p>");
            out.println("</body>");
            out.println("</html>");
        }
        */
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
