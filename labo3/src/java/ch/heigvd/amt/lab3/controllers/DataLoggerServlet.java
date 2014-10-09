/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab3.controllers;

import ch.heigvd.amt.lab3.model.Measure;
import ch.heigvd.amt.lab3.services.MeasuresManagerLocal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RigHitZ
 */
@WebServlet(name = "DataLoggerServlet", urlPatterns = {"/DataLoggerServlet"})
public class DataLoggerServlet extends HttpServlet {

    @EJB
    MeasuresManagerLocal measureManager;

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

        BufferedReader br = request.getReader();
        String tmpLine;
        String[] lineElements;
        String stationID;
        double measureData;
        long timestamp;

        int invalidLines = 0;
        while ((tmpLine = br.readLine()) != null) {
            lineElements = tmpLine.split(",");
            if (lineElements.length != 3) {
                invalidLines++;
            } else {
                stationID = lineElements[0];
                try {
                    measureData = Double.parseDouble(lineElements[1]);
                    timestamp = Long.parseLong(lineElements[2]);
                    
                    measureManager.addMeasure(new Measure(stationID, timestamp, measureData));
                    
                } catch (NumberFormatException nfe) {
                    invalidLines++;
                }

            }
        }
        
        
         response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DataLoggerServlet responding</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FrontControllerServlet at " + request.getContextPath() + "</h1>");
            out.println("<p>invalid measures : " +invalidLines+"</p>");
            out.println("<p>added measures : " +measureManager.getMeasures().size()+"</p>");
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
