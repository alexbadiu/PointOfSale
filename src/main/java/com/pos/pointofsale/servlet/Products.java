/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.pointofsale.servlet;

import com.pos.pointofsale.EJB.ProductBean;
import com.pos.pointofsale.EJB.ProductSpecificationBean;
import com.pos.pointofsale.details.ProductSpecificationDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
@DeclareRoles({"AdminRole", "ManagerRole", "CashierRole"})
@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {
                    "ManagerRole"
                })
)
@WebServlet(name = "Products", urlPatterns = {"/Products"})
public class Products extends HttpServlet {

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
    private ProductBean productBean;
    
    @Inject
    private ProductSpecificationBean productSpecificationBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Products</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Products at " + request.getContextPath() + "</h1>");
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
        
        List<ProductSpecificationDetails> productSpecifications = productSpecificationBean.getAllProductSpecifications();
        request.setAttribute("productSpecifications", productSpecifications);
        
        request.getRequestDispatcher("/WEB-INF/pages/products.jsp").forward(request, response);
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
        
        String[] productSpecificationIdsAsString = request.getParameterValues("product_ids");
        if (productSpecificationIdsAsString != null) {
            List<Integer> productSpecificationIds = new ArrayList<>();
            List<Integer> productIds = new ArrayList<>();
            for (String productSpecificationIdAsString : productSpecificationIdsAsString) {
                productSpecificationIds.add(Integer.parseInt(productSpecificationIdAsString));
            } 
            
            for (Integer productSpecificationId : productSpecificationIds) {
                ProductSpecificationDetails productSpecification = productSpecificationBean.findById(productSpecificationId);
                productIds.add(productSpecification.getProdId());
            }
            
            productSpecificationBean.deleteProductSpecificationsByIds(productSpecificationIds);
            productBean.deleteProductsByIds(productIds);
        }
        
        response.sendRedirect(request.getContextPath() + "/Products");
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
