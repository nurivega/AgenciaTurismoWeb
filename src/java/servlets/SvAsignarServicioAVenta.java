/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import static logica.Paquete_.listaServicios;
import logica.Servicio;
import logica.Venta;

/**
 *
 * @author nurivega
 */
@WebServlet(name = "SvAsignarServicioAVenta", urlPatterns = {"/SvAsignarServicioAVenta"})
public class SvAsignarServicioAVenta extends HttpServlet {


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
        
        int idServ = Integer.parseInt(request.getParameter("idServicio"));
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));

        Venta venta = controladora.obtenerVenta(idVenta);
        Servicio s = controladora.obtenerServicio(idServ);

        s.getListaVentas().add(venta);

        controladora.modificarServicio(s);
        
        
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
