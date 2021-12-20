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
import logica.Servicio;
import logica.Usuario;

/**
 *
 * @author nurivega
 */
@WebServlet(name = "SvModificarUsuario", urlPatterns = {"/SvModificarUsuario"})
public class SvModificarUsuario extends HttpServlet {

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
         int id = Integer.parseInt(request.getParameter("id"));
       String nombre = request.getParameter("nombre");
       String contrasenia = request.getParameter("contrasenia");
       
       Controladora control = new Controladora();
       Usuario usuario = control.obtenerUsuarioUnico(id);
       usuario.setNombre(nombre);
       usuario.setContrasenia(contrasenia);
     
     
       control.modificarUsuario(usuario);
       
       request.getSession().setAttribute("usuarioCompleto", usuario);
       response.sendRedirect("usuarios.jsp");    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Controladora control = new Controladora();
        Usuario usuario = control.obtenerUsuarioUnico(id);
       
        
       
       request.getSession().setAttribute("usuarioCompleto", usuario);
       response.sendRedirect("modificarUsuario.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
