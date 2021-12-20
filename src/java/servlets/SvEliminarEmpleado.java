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
import logica.Empleado;
import logica.Venta;

/**
 *
 * @author nurivega
 */
@WebServlet(name = "SvEliminarEmpleado", urlPatterns = {"/SvEliminarEmpleado"})
public class SvEliminarEmpleado extends HttpServlet {

   
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
       int id = Integer.parseInt(request.getParameter("id"));
       
        Controladora control = new Controladora();
        
        Empleado empleado = control.obtenerEmpleado(id);

        List<Venta> ventas = control.listarVentas();

        Iterator<Venta> listaVentas = ventas.iterator();
        boolean eliminar = true;
        
        while (listaVentas.hasNext()) {
            Venta venta = listaVentas.next();
            Iterator<Venta> ventasEmpleado = empleado.getListaVentas().iterator();
            if (ventasEmpleado != null) {
                while (ventasEmpleado.hasNext()) {
                    Venta ventaEmpleado = ventasEmpleado.next();
                    if (ventaEmpleado.getCodigo() == venta.getCodigo()) {
                        eliminar = false; 
                    }
                }
            }
        }
     
        if(eliminar) {
         //controladora.modificarPaquete(paquete);
        control.eliminarEmpleado(id);
        }
        request.getSession().setAttribute("listaPersonas", control.listarEmpleados());
       response.sendRedirect("empleados.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
