/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.pointofsale.servlet;

import com.pos.pointofsale.EJB.ProductSpecificationBean;
import com.pos.pointofsale.EJB.SaleBean;
import com.pos.pointofsale.EJB.StoreBean;
import com.pos.pointofsale.EJB.TemporarBean;
import com.pos.pointofsale.EJB.UserBean;
import com.pos.pointofsale.details.ProductSpecificationDetails;
import com.pos.pointofsale.details.TemporarDetails;
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
 * @author Asus
 */
@WebServlet(name = "ProcessSale", urlPatterns = {"/ProcessSale"})
public class ProcessSale extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Inject
    TemporarBean temporarBean;
    
    @Inject
    SaleBean saleBean;
    
    @Inject
    UserBean userBean;
    
    @Inject
    StoreBean storeBean;
    
    @Inject
    ProductSpecificationBean productSpecificationBean;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcessSale</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessSale at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
        //request.getRequestDispatcher("/WEB-INF/pages/ceva.jsp").forward(request, response);
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
        
        LocalDate saleDate = LocalDate.now();
        LocalTime saleTime = LocalTime.now(); 
        UserDetails userDetails = userBean.findByName(request.getRemoteUser());
        Integer userId = userDetails.getId();
        Integer storeId = 3;
        Double paymentAmount = temporarBean.getTotal();
        
        saleBean.createSale(saleDate, saleTime, userId, storeId, paymentAmount);
        
        List<TemporarDetails> temporarDetailsList = temporarBean.getAllTemporars();
        
        for (TemporarDetails temporarDetails : temporarDetailsList) {
            
            String productName = temporarDetails.getName();
            ProductSpecificationDetails prodSpecDetails = productSpecificationBean.findByName(productName);
            
            productSpecificationBean.updateProductSpecification(
                prodSpecDetails.getId(),
                prodSpecDetails.getDescription(),
                prodSpecDetails.getPrice(),
                prodSpecDetails.getUnitOnStock() - temporarDetails.getQuantity(),
                prodSpecDetails.getProdId(),
                prodSpecDetails.getBarcode());
        }
        temporarBean.removeAll();
       
        request.getRequestDispatcher("/index.jsp").forward(request, response);
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
