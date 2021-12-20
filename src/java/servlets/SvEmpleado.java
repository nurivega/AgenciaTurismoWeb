/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.Date;
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

//utilizamos los servlets para la comunicacion entre el servidor y  el frontend
@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {

    //declaro una instancia de la controladora
     Controladora controladoraEmpleado = new Controladora();
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) //proceso para la comunicacion entre el servidor y el cliente
            throws ServletException, IOException {
        
    } 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) //el metodo doGet lo utilizamos para lectura
            throws ServletException, IOException {
        processRequest(request, response);
    }

    //recibimos los datos para el alta y lo pasamos a la logica, por ejemplo recibimos los datos de un formulario del frontend para realizar un alta
    //el dopost recibe esos datos y se los pasa a la controladora
    
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
       Date fechaNacimiento = null;
         try {
             fechaNacimiento = formato.parse(request.getParameter("fechaNacimiento"));
         } catch (ParseException ex) {
             Logger.getLogger(SvEmpleado.class.getName()).log(Level.SEVERE, null, ex);
         }
         
       String email = request.getParameter("email");
       String cargo = request.getParameter("cargo");
       Double sueldo = Double.parseDouble(request.getParameter("sueldo"));
       String usuario = request.getParameter("usuario");
       String contrasenia = request.getParameter("contrasenia");
       
      controladoraEmpleado.crearEmpleado(nombre, apellido, direccion, dni, telefono, nacionalidad, fechaNacimiento, email, cargo, sueldo, usuario, contrasenia);
      
      //una vez que guarda el nuevo empleado redirecciona a la pagina de inicio
      response.sendRedirect("empleados.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
