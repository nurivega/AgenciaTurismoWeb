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

/**
 *
 * @author nurivega
 */
@WebServlet(name = "SvModificarEmpleado", urlPatterns = {"/SvModificarEmpleado"})
public class SvModificarEmpleado extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
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
       
       Controladora control = new Controladora();
       Empleado empleado = control.obtenerEmpleado(id);
       empleado.setNombre(nombre);
       empleado.setApellido(apellido);
       empleado.setDireccion(direccion);
       empleado.setDni(dni);
       empleado.setCelular(telefono);
       empleado.setNacionalidad(nacionalidad);
       empleado.setFechaNacimiento(fechaNacimiento);
       empleado.setEmail(email);
       empleado.setCargo(cargo);
       empleado.setSueldo(sueldo);
       
       control.modificarEmpleado(empleado);
       
       request.getSession().setAttribute("empleado", empleado);
       response.sendRedirect("empleados.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Controladora control = new Controladora();
        Empleado empleado = control.obtenerEmpleado(id);
        //actualizo la lista de empleados
        
       //guardo al empleado como un objeto para poder utilizarlo en otros jsp, por ejemplo en modificar empleado.
       request.getSession().setAttribute("empleado", empleado);
       response.sendRedirect("modificarEmpleado.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
