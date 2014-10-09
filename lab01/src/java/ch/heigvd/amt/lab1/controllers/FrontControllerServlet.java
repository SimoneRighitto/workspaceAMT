/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab1.controllers;

import ch.heigvd.amt.lab1.model.Measure;
import ch.heigvd.amt.lab1.services.MeasuresManager;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jboss.weld.servlet.SessionHolder;

/**
 *
 * @author RigHitZ
 */
@WebServlet(name = "FrontControllerServlet", urlPatterns = {"/FrontControllerServlet"})
public class FrontControllerServlet extends HttpServlet {
    
    ///// Attention ! 
    //Here we only have to write thread and concurrence safe code !!!
    ///
    ///Moreover, if we place
    //MeasuresManager measureManager = new MeasuresManager();
    //List<Measure> measures = measureManager.getMeasures();
    //here the object is instancieted only one time and it is not called at every request...
    //so the problem for our exemple is that the measures list is generated only one time
    ///
    
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
      
        
       
       MeasuresManager measureManager = new MeasuresManager();
       List<Measure> measures = measureManager.getMeasures();
        
        response.setContentType("text/html;charset=UTF-8");
        
        
        
        try (PrintWriter out = response.getWriter()) {
            
             ////iteration1 slide 54
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet FrontControllerServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet FrontControllerServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
                  
 ////
        
       
 
        ////iteration 2 slide 54
        //request.getRequestDispatcher("WEB-INF/views/measures.jsp").forward(request, response);
        
        ////
        
        ////iteration 3
            
            //here we attach the message to the request scope... we also attach the message to the global or session scope
            //to let the object be accessible even when the request is done on the jsp by the ${sessionScope.message}
        request.setAttribute("message", "iteration3 Message ;-)");
        
        request.setAttribute("measuresData", measures);
        request.getRequestDispatcher("WEB-INF/views/measures.jsp").forward(request, response);
        ///
        
        //we add some objects on the session for testing in Labo2
        HttpSession session= request.getSession();
        session.setAttribute("bigObject", new Byte[50000]);
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
