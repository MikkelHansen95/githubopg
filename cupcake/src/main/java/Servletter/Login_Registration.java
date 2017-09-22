/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servletter;

import Mapper.*;
import entities.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GertLehmann
 */
@WebServlet(name = "Login_Registration", urlPatterns = {"/Login_Registration"})
public class Login_Registration extends HttpServlet {

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

        String loginSite = request.getParameter("login");

        UserMapper um = new UserMapper();
        CupcakeMapper cm = new CupcakeMapper();
            String username = request.getParameter("username");
            String password = request.getParameter("password");

        
        if (loginSite.equals("true")) {

            User loggedInUser = um.getUserByName(username);
            ArrayList<Topping> toppingList = (ArrayList) (cm.getListOfTops());
            ArrayList<Bottom> bottomList = (ArrayList) (cm.getListOfBots());
            ArrayList<Orderline> orderLines = new ArrayList();
            double totalPrice = 0;
            
            if (loggedInUser == null) {
                request.getRequestDispatcher("Errorpages/_error.jsp")
                        .forward(request, response);

            } else if (!loggedInUser.getPassword().equals(password)) {
                request.getRequestDispatcher("Errorpages/login_error.jsp")
                        .forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", loggedInUser);
                session.setAttribute("toppingList", toppingList);
                session.setAttribute("bottomList", bottomList);
                session.setAttribute("orderLines", orderLines);
                session.setAttribute("totalPrice", totalPrice);

                request.getRequestDispatcher("shopCart.jsp")
                        .forward(request, response);
            }

        } else {
                    
        User testNameUser = um.getUserByName(username);
        
        if (testNameUser.getUser_id()!=0) {
            request.getRequestDispatcher("Errorpages/error_user_exist.jsp")
                    .forward(request, response);
        } else {
            double balance = Double.parseDouble(request.getParameter("balance"));
            String email = request.getParameter("email");

            User newUser = new User(username, password, balance, email);

            try {
                um.putUser(newUser);
                    request.getRequestDispatcher("Subpages/register_completed.jsp")
                            .forward(request, response);
                
            } catch (SQLException ex) {
                request.getRequestDispatcher("Errorpages/error_not_registered.jsp")
                        .forward(request, response);

            }

        }

        }

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
