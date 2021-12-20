/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Paquete;
import logica.Venta;

/**
 *
 * @author nurivega
 */
@WebServlet(name = "SvAsignarPaqueteAVenta", urlPatterns = {"/SvAsignarPaqueteAVenta"})
public class SvAsignarPaqueteAVenta extends HttpServlet {

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
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controladora controladora = new Controladora();
        
        int idPaquete = Integer.parseInt(request.getParameter("idPaquete"));
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));

        Venta venta = controladora.obtenerVenta(idVenta);
        Paquete paquete = controladora.obtenerPaquete(idPaquete);
        paquete.getListaVentas().add(venta);
        controladora.modificarPaquete(paquete);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("venta", venta);
       //redirijo la pagina a la siguiente seccion para que se elija el cliente que realizo la compra
       response.sendRedirect("asignarClienteAVenta.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
