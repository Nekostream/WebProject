/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mr.Debug
 */
public class MainController extends HttpServlet {

    public boolean isValidLogin(String name, String password){
        return name.equals("admin")&&password.equals("12345678");
    }
    
    
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String txtName = request.getParameter("txtName");
           String txtPassword = request.getParameter("txtPassword");
       
          if(txtPassword.trim().length()==0||txtName.trim().length()==0){
           out.println("Please enter name and password");
          }
        
           if(txtPassword.trim().length() <=8){
              out.println("Password need to be longer than 8");
         
              
          }
       
          //Admin login
          if(isValidLogin(txtName,txtPassword)){
                // If login credentials are valid, forward the request to "search.html"
                // RequestDispatcher is used here to forward the request and response
                // Forwarding happens on the server side, and the URL in the browser does not change
        RequestDispatcher rd = request.getRequestDispatcher("search.html");
        rd.forward(request, response);
          }else{
       // RequestDispatcher rd = request.getRequestDispatcher("invalid.html");
        //rd.forward(request, response);
        
        
                // If login credentials are invalid, redirect to "invalid.html"

                // Using sendRedirect causes the server to instruct the client to make a new HTTP request to "invalid.html"
                // This results in the URL in the browser changing to "invalid.html"
          response.sendRedirect("invalid.html");
              // Alternative option (commented out):
                // Using RequestDispatcher would forward the request and response to "invalid.html" on the server side
                // The URL in the browser would remain the same as the original login page
                // RequestDispatcher rd = request.getRequestDispatcher("invalid.html");
                // rd.forward(request, response);
                // Comment: The difference between rd.forward and response.sendRedirect:
                // - rd.forward: Server-side forwarding, URL does not change
                // - response.sendRedirect: Client-side redirection, URL changes
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
