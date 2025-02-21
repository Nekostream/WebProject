/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DTO.UserDTO;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SideQuest
 */
public class MainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String LOGIN_PAGE="login.jsp";
    
    
    public UserDTO getUser(String strUserID){
         UserDAO dao = new UserDAO();
        UserDTO user = dao.readbyID(strUserID);
        return user;
    }
    
    public boolean isValidLogin(String strUserID,String strPassword){
        UserDTO user = getUser(strUserID);
        if(user != null && user.getPassword().equals(strPassword)){
            return false;
        }else{
            if(user.getPassword().equals(strPassword)){
                return true;
            }else{
            return false;
            }
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String url =LOGIN_PAGE;
           try{
               String action = request.getParameter("action");
               if(action == null){
                   url = LOGIN_PAGE;
               }if(action != null && action.equals("login")){
                   String strUserID = request.getParameter("strUserID");
                   String strPassword = request.getParameter("strPassword");
                   if(isValidLogin(strUserID,strPassword)){
                       url="user.jsp";
                       UserDTO user = getUser(strUserID);
                       request.setAttribute("user", user);
                   }else{
                       url ="invalid.jsp";
                   }
               }
           }catch(Exception ex){
               log("Error at MainController"+ex.toString());
           }finally{
               RequestDispatcher rd = request.getRequestDispatcher(url);
               rd.forward(request, response);
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
