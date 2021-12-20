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
import logica.Controladora;
import logica.Servicio;
import logica.Venta;

/**
 *
 * @author nurivega
 */
@WebServlet(name = "SvPaquete", urlPatterns = {"/SvPaquete"})
public class SvPaquete extends HttpServlet {

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
        
        //obtengo los servicios seleccionados
        String serviciosSeleccionados[]= request.getParameterValues("seleccionado");
        List <Servicio> servicios = new ArrayList<>();
        
        double costoPaquete=0;
        if (serviciosSeleccionados !=null) {
            for (int i = 0; i < serviciosSeleccionados.length; i++) {
               Servicio servicio = controladora.obtenerServicio(Integer.parseInt(serviciosSeleccionados[i])); 
               costoPaquete=costoPaquete+servicio.getCosto();
               //aplico el 10% de descuento
                double descuento = costoPaquete* 0.10;
                costoPaquete = costoPaquete - descuento;
               //guardo los servicios dentro del arraylist servicios
               servicios.add(servicio);
           
            }
            //le paso el costo total y el arraylist de servicios a la funcion crear paquete
            controladora.crearPaquete(costoPaquete,servicios); 
            
        }
        
        
             response.sendRedirect("paquetes.jsp");
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
