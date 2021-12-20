/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import static logica.Empleado_.usuario;
import logica.Usuario;

@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {

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
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");
        
        int codigoUsuario = 0;

        Controladora control = new Controladora();
        //me devuelve true si el usuario existe
        boolean autorizado = control.verificarUsuario(usuario, contrasenia);
        
        if (autorizado == true) {
            codigoUsuario = control.obtenerCodigoUsuario(usuario, contrasenia);
            Usuario usuarioEmpleado = control.obtenerUsuarioUnico(codigoUsuario);
            
            HttpSession misession = request.getSession();
            misession.setAttribute("usuario", usuario);
            misession.setAttribute("contrasenia", contrasenia);
            
            misession.setAttribute("usuarioEmpleado", usuarioEmpleado);
            
            response.sendRedirect("inicio.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
