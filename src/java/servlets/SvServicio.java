/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;

/**
 *
 * @author nurivega
 */
@WebServlet(name = "SvServicio", urlPatterns = {"/SvServicio"})
public class SvServicio extends HttpServlet {
    
     Controladora controladoraServicio = new Controladora();

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
       String nombre = request.getParameter("nombre");
       String descripcion = request.getParameter("descripcion");
       String destino = request.getParameter("destino");
       double costo = Double.parseDouble(request.getParameter("costo"));
       SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");  
       Date fechaSalida = null;
         try {
             fechaSalida = formato.parse(request.getParameter("fechaSalida"));
         } catch (ParseException ex) {
             Logger.getLogger(SvEmpleado.class.getName()).log(Level.SEVERE, null, ex);
         }
         controladoraServicio.crearServicio(nombre, descripcion, destino, costo, fechaSalida);
        response.sendRedirect("servicios.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
