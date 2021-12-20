<%-- 
    Document   : usuarios
    Created on : 09-dic-2021, 19:21:10
    Author     : nurivega
--%>

<%@page import="logica.Usuario"%>
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
							<a href="paquetes.jsp"><i class="zmdi zmdi-timer zmdi-hc-fw"></i> Paquetes</a>
						</li>
						<li>
							<a href="servicios.jsp"><i class="zmdi zmdi-book zmdi-hc-fw"></i> Servicios</a>
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
			  <h1 class="text-titles"><i class="zmdi zmdi-account zmdi-hc-fw"></i> Usuarios</h1>
			
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
					<ul class="nav nav-tabs" style="margin-bottom: 15px;">
					  	<li><a href="#list" data-toggle="tab">Lista de usuarios</a></li>
					</ul>
					  	<div class="tab-pane fade active in" id="new">
							<div class="table-responsive">
								<table class="table table-hover text-center">
									<thead>
										<tr>
											<th class="text-center">Nombre</th>
											<th class="text-center">Contraseña</th>
                                                                                        <th class="text-center">Actualizar</th>
                                                                                       
                                                                                        
										</tr>
									</thead>
									<tbody>
                                                                            <% Controladora controladora = new Controladora(); 
                                                                              List<Usuario> listaUsuarios = controladora.listarUsuarios();
                                                                              for (Usuario usu : listaUsuarios){
                                                                            %>
										<tr>
                                                                                    <% String nombre = usu.getNombre();%>
											<td><%=nombre%></td>
                                                                                    <% String contrasenia = usu.getContrasenia();%>
                                                                                        <td><%=contrasenia%></td>
                                                                                     <%int id = usu.getCodigo();%>
											<td>
                                                                                            <form name="frmActualizarUsuario" action="SvModificarUsuario" method="post">
                                                                                                <input type="hidden" name="id" value="<%=id%>">
                                                                                                <button type="submit" href="#!" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i></button>
                                                                                            </form>
                                                                                        </td>    
										</tr>
									</tbody>
                                                                        <%}%>
								</table>
								
							</div>
					  	</div>
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