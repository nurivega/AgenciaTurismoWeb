/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Servicio;
import logica.Venta;

/**
 *
 * @author nurivega
 */
@WebServlet(name = "SvEliminarServicio", urlPatterns = {"/SvEliminarServicio"})
public class SvEliminarServicio extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvEliminarServicio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvEliminarServicio at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id"));
        Controladora control = new Controladora();
        Servicio servicio = control.obtenerServicio(id);
        
         List<Venta> ventas = control.listarVentas();

        Iterator<Venta> listaVentas = ventas.iterator();
           boolean eliminar = true;
        
        while (listaVentas.hasNext()) {
            Venta venta = listaVentas.next();
            Iterator<Venta> ventasServicio = servicio.getListaVentas().iterator();
            if (ventasServicio != null) {
                while (ventasServicio.hasNext()) {
                    Venta ventaServ = ventasServicio.next();
                    if (ventaServ.getCodigo() == venta.getCodigo()) {
                        eliminar = false; 
                    }
                }
            }
        }
     
        if(eliminar) {
         //controladora.modificarPaquete(paquete);
        control.eliminarServicio(id);
        }
        //actualizo la lista de clientes
       request.getSession().setAttribute("listaServicios", control.listarServicio());
       response.sendRedirect("servicios.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
