/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.pointofsale.servlet;

import com.pos.pointofsale.EJB.ProductBean;
import com.pos.pointofsale.EJB.ProductSpecificationBean;
import com.pos.pointofsale.EJB.TemporarBean;
import com.pos.pointofsale.details.ProductSpecificationDetails;
import com.pos.pointofsale.details.TemporarDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"CashierRole"}))
@WebServlet(name = "AddSale", urlPatterns = {"/AddSale"})
public class AddSale extends HttpServlet {
    
    @Inject
    ProductSpecificationBean productSpecificationBean;
    
    @Inject
    TemporarBean temporarBean;
    
    @Inject
    ProductBean productBean;
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
        temporarBean.removeAll();
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
        
        String barcode = request.getParameter("barcode");
        
        if (barcode == "") {
            List<TemporarDetails> temporarProducts = temporarBean.getAllTemporars();
            request.setAttribute("temporarProducts", temporarProducts);

            Double total = temporarBean.getTotal();
            request.setAttribute("total", total);
            
            request.getRequestDispatcher("/WEB-INF/pages/addSale.jsp").forward(request, response);
        } else {
            ProductSpecificationDetails prodSpecDetails = productSpecificationBean.findByBarcode(barcode);
            if(prodSpecDetails == null){
                List<TemporarDetails> temporarProducts = temporarBean.getAllTemporars();
                request.setAttribute("temporarProducts", temporarProducts);

                Double total = temporarBean.getTotal();
                request.setAttribute("total", total);
                request.getRequestDispatcher("/WEB-INF/pages/addSale.jsp").forward(request, response);
            } else {
                
                Integer quantity = Integer.parseInt(request.getParameter("quantity"));

                TemporarDetails t = temporarBean.findByName(prodSpecDetails.getProdName());
                if(t!=null)
                {
                    Integer id = t.getId();
                    Integer quant = quantity+t.getQuantity();
                    Double  price = prodSpecDetails.getPrice()*quant;
                    temporarBean.updateTotal(id, quant, price);

                }
                else
                {
                    temporarBean.createTemporar(prodSpecDetails.getProdName(), prodSpecDetails.getDescription(), prodSpecDetails.getPrice(),quantity);
                }

                List<TemporarDetails> temporarProducts = temporarBean.getAllTemporars();
                request.setAttribute("temporarProducts", temporarProducts);

                Double total = temporarBean.getTotal();
                request.setAttribute("total", total);

                request.getRequestDispatcher("/WEB-INF/pages/addSale.jsp").forward(request, response);
            }
        }
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
