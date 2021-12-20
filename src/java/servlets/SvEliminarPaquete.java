/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Paquete;
import logica.Servicio;
import logica.Venta;

/**
 *
 * @author nurivega
 */
@WebServlet(name = "SvEliminarPaquete", urlPatterns = {"/SvEliminarPaquete"})
public class SvEliminarPaquete extends HttpServlet {

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

        int id = Integer.parseInt(request.getParameter("idPaquete"));
        Controladora controladora = new Controladora();
        
        Paquete paquete = controladora.obtenerPaquete(id);

        List<Venta> ventas = controladora.listarVentas();

        Iterator<Venta> listaVentas = ventas.iterator();
        boolean eliminar = true;
        
        while (listaVentas.hasNext()) {
            Venta venta = listaVentas.next();
            Iterator<Venta> ventasPaquete = paquete.getListaVentas().iterator();
            if (ventasPaquete != null) {
                while (ventasPaquete.hasNext()) {
                    Venta ventaPaquete = ventasPaquete.next();
                    if (ventaPaquete.getCodigo() == venta.getCodigo()) {
                        eliminar = false; 
                    }
                }
            }
        }
     
        if(eliminar) {
         //controladora.modificarPaquete(paquete);
        controladora.eliminarPaquete(id);
        }
       
        //actualizo la lista de empleados
        request.getSession().setAttribute("listaPaquete", controladora.listarPaquetes());
        response.sendRedirect("paquetes.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
