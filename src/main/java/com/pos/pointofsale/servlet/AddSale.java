/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.pointofsale.servlet;

import com.pos.pointofsale.EJB.SaleBean;
import com.pos.pointofsale.EJB.StoreBean;
import com.pos.pointofsale.EJB.UserBean;
import com.pos.pointofsale.details.StoreDetails;
import com.pos.pointofsale.details.UserDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
@WebServlet(name = "AddSale", urlPatterns = {"/AddSale"})
public class AddSale extends HttpServlet {
    
    @Inject
    SaleBean saleBean;
    
    @Inject
    UserBean userBean;
    
    @Inject
    StoreBean storeBean;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddSale</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddSale at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        
        List<UserDetails> users = userBean.getAllUsers();
        request.setAttribute("users", users);
        
        List<StoreDetails> stores = storeBean.getAllStores();
        request.setAttribute("stores", stores);
        
        request.getRequestDispatcher("/WEB-INF/pages/addSale.jsp").forward(request, response);
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
        //processRequest(request, response);
        
        LocalDate saleDate = LocalDate.now();
        LocalTime saleTime = LocalTime.now();
        
        int cashierId = Integer.parseInt(request.getParameter("cashierId"));
        int storeId = Integer.parseInt(request.getParameter("storeId"));
        double paymentAmount = Double.parseDouble(request.getParameter("paymentAmount"));
        
        saleBean.createSale(saleDate, saleTime, cashierId, storeId, paymentAmount);
        
        response.sendRedirect(request.getContextPath() + "/Sales");
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
