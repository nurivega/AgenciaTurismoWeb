/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;


@WebServlet(name = "SvCliente", urlPatterns = {"/SvCliente"})
public class SvCliente extends HttpServlet {

    Controladora controladoraCliente = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  // el metodo doPost lo utilizamos para alta baja y modificacion
            throws ServletException, IOException {
       String nombre = request.getParameter("nombre");
       String apellido = request.getParameter("apellido");
       String direccion = request.getParameter("direccion");
       String dni = request.getParameter("dni");
       String telefono = request.getParameter("telefono");
       String nacionalidad = request.getParameter("nacionalidad");
       SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");  
       java.util.Date fechaNacimiento = null;
         try {
             fechaNacimiento = formato.parse(request.getParameter("fechaNacimiento"));
         } catch (ParseException ex) {
             Logger.getLogger(SvEmpleado.class.getName()).log(Level.SEVERE, null, ex);
         }
       String email = request.getParameter("email");

       
      controladoraCliente.crearCliente(nombre, apellido, direccion, dni, telefono, nacionalidad, fechaNacimiento, email);
      
      //una vez que guarda el nuevo empleado redirecciona a la pagina de inicio
      response.sendRedirect("clientes.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
