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
import logica.Empleado;
import logica.Servicio;

/**
 *
 * @author nurivega
 */
@WebServlet(name = "SvModificarServicio", urlPatterns = {"/SvModificarServicio"})
public class SvModificarServicio extends HttpServlet {

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
     
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("id"));
       String nombre = request.getParameter("nombre");
       String descripcion = request.getParameter("descripcion");
       String destino = request.getParameter("destino");
       double costo = Double.parseDouble(request.getParameter("costo"));
       SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");  
       Date fechaInicio = null;
         try {
             fechaInicio = formato.parse(request.getParameter("fechaInicio"));
         } catch (ParseException ex) {
             Logger.getLogger(SvEmpleado.class.getName()).log(Level.SEVERE, null, ex);
         }
      
       
       Controladora control = new Controladora();
       Servicio servicio = control.obtenerServicio(id);
       servicio.setNombre(nombre);
       servicio.setDescripcion(descripcion);
       servicio.setDestino(destino);
       servicio.setCosto(costo);
       servicio.setFechaInicio(fechaInicio);
     
       control.modificarServicio(servicio);
       
       request.getSession().setAttribute("servicio", servicio);
       response.sendRedirect("servicios.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id"));
        Controladora control = new Controladora();
        Servicio servicio = control.obtenerServicio(id);
        //actualizo la lista de empleados
        
       //guardo al empleado como un objeto para poder utilizarlo en otros jsp, por ejemplo en modificar empleado.
       request.getSession().setAttribute("servicio", servicio);
       response.sendRedirect("modificarServicio.jsp");
       
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
