/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Dao.UserDao;
import Entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;

/**
 *
 * @author ayoub
 */
public class LoginServlet extends HttpServlet {

    
    UserDao dao = new UserDao();
    User user = null;
    HttpSession session;
    
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
        try{
            if(request.getParameter("login") != null && request.getParameter("password") != null){
                String login = request.getParameter("login");
                String password= request.getParameter("password");
                
                session = request.getSession();
                user = dao.getLogin(login, password);
                
                if(user != null){
                    session.setAttribute("login", login);
                    session.setAttribute("isLogged", 1);
                
                    response.sendRedirect("/GED/EmpDepServlet?action=ListeDepartement"); 
                } else {
                    session.invalidate();
                    response.sendRedirect("index.jsp");
                    return; // <--- Here.
                } 
            }else{
                response.sendRedirect("index.jsp");
                return; // <--- Here.
            }   
            
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        
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
