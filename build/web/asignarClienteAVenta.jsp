<%@page import="logica.Usuario"%>
<%@page import="logica.Venta"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="logica.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Admin</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="./css/main.css">
    </head>
    <body>
          <% HttpSession misession = request.getSession();
    String usuario = (String) misession.getAttribute("usuario");
    if(usuario ==null){
        response.sendRedirect("index.jsp");
    }
    %>
        <!-- SideBar -->
        <section class="full-box cover dashboard-sideBar">
            <div class="full-box dashboard-sideBar-bg btn-menu-dashboard"></div>
            <div class="full-box dashboard-sideBar-ct">
                <!--SideBar Title -->
                <div class="full-box text-uppercase text-center text-titles dashboard-sideBar-title">
                    Empresa <i class="zmdi zmdi-close btn-menu-dashboard visible-xs"></i>
                </div>
                <!-- SideBar User info -->
                <div class="full-box dashboard-sideBar-UserInfo">
                    <figure class="full-box">
                        <img src="./assets/icons/user.png" alt="UserIcon">
                        <figcaption class="text-center text-titles"><%=usuario%></figcaption>
                    </figure>

                </div>
                <!-- SideBar Menu -->
                <ul class="list-unstyled full-box dashboard-sideBar-Menu">
                    <li>
                        <a href="inicio.jsp">
                            <i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i> Inicio
                        </a>
                    </li>
                    <li>
                        <a href="#!" class="btn-sideBar-SubMenu">
                            <i class="zmdi zmdi-account-add zmdi-hc-fw"></i> Usuarios <i class="zmdi zmdi-caret-down pull-right"></i>
                        </a>
                        <ul class="list-unstyled full-box">
                            <li>
                                <a href="usuarios.jsp"><i class="zmdi zmdi-account zmdi-hc-fw"></i> Administracion de usurios</a>
                            </li>

                        </ul>
                    </li>
                    <li>
                        <a href="#!" class="btn-sideBar-SubMenu">
                            <i class="zmdi zmdi-account-add zmdi-hc-fw"></i> Empleados y clientes <i class="zmdi zmdi-caret-down pull-right"></i>
                        </a>
                        <ul class="list-unstyled full-box">
                            <li>
                                <a href="empleados.jsp"><i class="zmdi zmdi-account zmdi-hc-fw"></i> Empleados</a>
                            </li>
                            <li>
                                <a href="clientes.jsp"><i class="zmdi zmdi-male-alt zmdi-hc-fw"></i> Clientes</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#!" class="btn-sideBar-SubMenu">
                            <i class="zmdi zmdi-case zmdi-hc-fw"></i> Paquetes y servicios <i class="zmdi zmdi-caret-down pull-right"></i>
                        </a>
                        <ul class="list-unstyled full-box">
                            <li>
                                <a href="paquetes.jsp"><i class="zmdi zmdi-airplane zmdi-hc-fw"></i> Paquetes</a>
                            </li>
                            <li>
                                <a href="servicios.jsp"><i class="zmdi zmdi-card-travel zmdi-hc-fw"></i> Servicios</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#!" class="btn-sideBar-SubMenu">
                            <i class="zmdi zmdi-card zmdi-hc-fw"></i> Ventas <i class="zmdi zmdi-caret-down pull-right"></i>
                        </a>
                        <ul class="list-unstyled full-box">
                            <li>
                                <a href="ventas.jsp"><i class="zmdi zmdi-money-box zmdi-hc-fw"></i> Ventas</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </section>

        <!-- Content page-->
        <section class="full-box dashboard-contentPage">
            <!-- NavBar -->
            <nav class="full-box dashboard-Navbar">
                <ul class="full-box list-unstyled text-right">
                    <li class="pull-left">
                        <a href="#!" class="btn-menu-dashboard"><i class="zmdi zmdi-more-vert"></i></a>
                    </li>
                </ul>
            </nav>
            <!-- Content page -->
            <div class="container-fluid">
                <div class="page-header">
                    <h1 class="text-titles"><i class="zmdi zmdi-account zmdi-hc-fw"></i> Usuarios <small>Clientes</small></h1>

                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-xs-12">
                                <ul class="nav nav-tabs" style="margin-bottom: 15px;">
                                    <li><a href="#list" data-toggle="tab">Seleccione un cliente para finalizar la venta</a></li>
                                </ul>
                                <form action="SvAsignarClienteAVenta" method="post">
                                    
                                            <%  
                                                Venta venta = (Venta) misession.getAttribute("venta");
                                                int idVenta = venta.getCodigo();
                                                Usuario usuarioEmpleado = (Usuario) misession.getAttribute("usuarioEmpleado");
                                                int idUsuarioEmpleado = usuarioEmpleado.getCodigo();
                                            %>
                                    <div class="tab-pane fade" id="list">
                                        <div class="table-responsive">

                                            <table class="table table-hover text-center">
                                                <thead>
                                                    <tr>
                                                        <th class="text-center">Nombre</th>
                                                        <th class="text-center">Apellido</th>
                                                        <th class="text-center">DNI</th>
                                                        <th class="text-center">Direccion</th>
                                                        <th class="text-center">Nacionalidad</th>
                                                        <th class="text-center">Fecha de nacimiento</th>
                                                        <th class="text-center">Email</th>
                                                        <th class="text-center">Telefono</th>

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <% Controladora controladora = new Controladora();
                                                        List<Cliente> listaClientes = controladora.listarClientes();
                                                        for (Cliente cli : listaClientes) {
                                                    %>
                                                    <tr>
                                                        <% String nombre = cli.getNombre();%>
                                                        <td><%=nombre%></td>
                                                        <% String apellido = cli.getApellido();%>
                                                        <td><%=apellido%></td>
                                                        <% String dni = cli.getDni();%>
                                                        <td><%=dni%></td> 

                                                        <% String direccion = cli.getDireccion();%>
                                                        <td><%=direccion%></td> 
                                                        <% String nacionalidad = cli.getNacionalidad();%>
                                                        <td><%=nacionalidad%></td>
                                                        <% Date fecha = cli.getFechaNacimiento();
                                                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                                                            String fechaNacimiento = sdf.format(fecha);
                                                        %>
                                                        <td><%=fechaNacimiento%></td> 
                                                        <% String email = cli.getEmail();%>
                                                        <td><%=email%></td> 
                                                        <% String telefono = cli.getCelular();%>
                                                        <td><%=telefono%></td>  
                                                        <%int id = cli.getCodigo();%>
                                                        <td><%=id%></td>
                                                        <td> 
                                                            <input type="hidden" name="idCliente" value="<%=id%>">
                                                            <input type="hidden" name="idVenta" value="<%=idVenta%>">
                                                            <input type="hidden" name="idUsuarioEmpleado" value="<%=idUsuarioEmpleado%>">
                                                            <button href="#!" class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-floppy"></i> Seleccionar y terminar</button>
                                                        </td>     
                                                    </tr>
                                                </tbody>
                                                <%}%>
                                            </table>
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
        </section>

        <!--====== Scripts -->
        <script src="./js/jquery-3.1.1.min.js"></script>
        <script src="./js/sweetalert2.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/material.min.js"></script>
        <script src="./js/ripples.min.js"></script>
        <script src="./js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="./js/main.js"></script>
        <script>
            $.material.init();
        </script>
    </body>
</html>