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
import logica.Cliente;
import logica.Controladora;
import logica.Empleado;
import logica.Paquete;
import logica.Servicio;
import logica.Venta;

/**
 *
 * @author nurivega
 */
@WebServlet(name = "SvEliminarVenta", urlPatterns = {"/SvEliminarVenta"})
public class SvEliminarVenta extends HttpServlet {

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

        int idVenta = Integer.parseInt(request.getParameter("idVenta"));

        Venta venta = controladora.obtenerVenta(idVenta);

        List<Cliente> clientes = controladora.listarClientes();
        List<Empleado> empleados = controladora.listarEmpleados();
        List<Servicio> servicios = controladora.listarServicio();
        List<Paquete> paquetes = controladora.listarPaquetes();

        Iterator<Paquete> listaPaquetes = paquetes.iterator();

        while (listaPaquetes.hasNext()) {
            Paquete paquete = listaPaquetes.next();
            Iterator<Venta> listaVentas = paquete.getListaVentas().iterator();
            if (listaVentas != null) {
                while (listaVentas.hasNext()) {
                    Venta v = listaVentas.next();
                    if (v.getCodigo() == venta.getCodigo()) {
                        listaVentas.remove();
                        controladora.modificarPaquete(paquete);
                    }
                }
            }

        }
        
        Iterator<Cliente> listaClientes = clientes.iterator();

        while (listaClientes.hasNext()) {
            Cliente cliente = listaClientes.next();
            Iterator<Venta> listaVentas = cliente.getComprasCliente().iterator();
            if (listaClientes != null) {
                while (listaVentas.hasNext()) {
                    Venta v = listaVentas.next();
                    if (v.getCodigo() == venta.getCodigo()) {
                        listaVentas.remove();
                        controladora.modificarCliente(cliente);
                    }
                }
            }
        }
        
        Iterator<Servicio> listaServicios = servicios.iterator();

        while (listaServicios.hasNext()) {
            Servicio servicio = listaServicios.next();
            Iterator<Venta> listaVentas = servicio.getListaVentas().iterator();
            if (listaVentas != null) {
                while (listaVentas.hasNext()) {
                    Venta v = listaVentas.next();
                    if (v.getCodigo() == venta.getCodigo()) {
                        listaVentas.remove();
                        controladora.modificarServicio(servicio);
                    }
                }
            }
        }
        
        Iterator<Empleado> listaEmpleados = empleados.iterator();

        while (listaEmpleados.hasNext()) {
            Empleado empleado = listaEmpleados.next();
            Iterator<Venta> listaVentas = empleado.getListaVentas().iterator();
            if (listaVentas != null) {
                while (listaVentas.hasNext()) {
                    Venta v = listaVentas.next();
                    if (v.getCodigo() == venta.getCodigo()) {
                        listaVentas.remove();
                        controladora.modificarEmpleado(empleado);
                    }
                }
            }
        }
        
        controladora.eliminarVenta(idVenta);

        response.sendRedirect("ventas.jsp");

    }





    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
