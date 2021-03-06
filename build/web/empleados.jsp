
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="logica.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="logica.Cliente"%>
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
			  <h1 class="text-titles"><i class="zmdi zmdi-account zmdi-hc-fw"></i> Usuarios <small>Empleados</small></h1>
			
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
					<ul class="nav nav-tabs" style="margin-bottom: 15px;">
					  	<li class="active"><a href="#new" data-toggle="tab">Nuevo empleado</a></li>
					  	<li><a href="#list" data-toggle="tab">Lista empleados</a></li>
					</ul>
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane fade active in" id="new">
							<div class="container-fluid">
								<div class="row">
									<div class="col-xs-12 col-md-10 col-md-offset-1">
                                                                            <form action="SvEmpleado" method="POST">
									    	<div class="form-group label-floating">
											  <label class="control-label">Nombre</label>
                                                                                          <input class="form-control" type="text" name="nombre">
											</div>
											<div class="form-group label-floating">
											  <label class="control-label">Apellido</label>
                                                                                          <input class="form-control" type="text" name="apellido">
											</div>
											<div class="form-group label-floating">
											  <label class="control-label">Direccion</label>
											  <input class="form-control" type="text" name="direccion">
											</div>
											<div class="form-group label-floating">
											  <label class="control-label">Dni</label>
                                                                                          <input class="form-control" type="text" name="dni">
											</div>
											<div class="form-group label-floating">
											  <label class="control-label">Telefono</label>
                                                                                          <input class="form-control" type="text" name="telefono">
											</div>
                                                                                        <div class="form-group label-floating">
											  <label class="control-label">Nacionalidad</label>
                                                                                          <input class="form-control" type="text" name="nacionalidad">
											</div>
                                                                                         <div class="form-group label-floating">
											  <label class="control-label">Fecha nacimiento</label>
                                                                                          <input class="form-control" type="date" name="fechaNacimiento">
											</div>
											<div class="form-group label-floating">
											  <label class="control-label">Email</label>
                                                                                          <input class="form-control" type="email" name="email">
											</div>
                                                                                        <div class="form-group label-floating">
											  <label class="control-label">Cargo</label>
                                                                                          <input class="form-control" type="text" name="cargo">
											</div>
                                                                                        <div class="form-group label-floating">
											  <label class="control-label">Sueldo</label>
                                                                                          <input class="form-control" type="text" name="sueldo">
											</div>
                                                                                        <div class="form-group label-floating">
											  <label class="control-label">Usuario</label>
                                                                                          <input class="form-control" type="text" name="usuario">
											</div>
                                                                                        <div class="form-group label-floating">
											  <label class="control-label">Contrase??a</label>
                                                                                          <input class="form-control" type="password" name="contrasenia">
											</div>
										    <p class="text-center">
										    	<button href="#!" class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-floppy"></i> Guardar</button>
										    </p>
									    </form>
									</div>
								</div>
							</div>
						</div>
					  	<div class="tab-pane fade" id="list">
							<div class="table-responsive">
								<table class="table table-hover text-center">
									<thead>
										<tr>
											<th class="text-center">Nombre</th>
											<th class="text-center">Apellido</th>
                                                                                        <th class="text-center">dni</th>
                                                                                        <th class="text-center">Direccion</th>
                                                                                        <th class="text-center">Telefono</th>
											<th class="text-center">Nacionalidad</th>
                                                                                        <th class="text-center">Fecha de nacimiento</th>
											<th class="text-center">Email</th>
                                                                                        <th class="text-center">Cargo</th>
                                                                                        <th class="text-center">Sueldo</th>
											<th class="text-center">Actualizar</th>
											<th class="text-center">Eliminar</th>
										</tr>
									</thead>
									<tbody>
                                                                            <% Controladora controladora = new Controladora(); 
                                                                              List<Empleado> listaEmpleados = controladora.listarEmpleados();
                                                                              for (Empleado emp : listaEmpleados){
                                                                            %>
										<tr>
                                                                                    <% String nombre = emp.getNombre();%>
											<td><%=nombre%></td>
                                                                                    <% String apellido = emp.getApellido();%>
                                                                                      <td><%=apellido%></td>
                                                                                     <% String dni = emp.getDni();%>
                                                                                      <td><%=dni%></td> 
                                                                                     <% String direccion = emp.getDireccion();%>
                                                                                      <td><%=direccion%></td> 
                                                                                     <% String telefono = emp.getCelular();%>
                                                                                      <td><%=telefono%></td>  
                                                                                      <% String nacionalidad = emp.getNacionalidad();%>
                                                                                      <td><%=nacionalidad%></td>
                                                                                      <% Date fecha = emp.getFechaNacimiento();
                                                                                      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                                                                                      String fechaNacimiento = sdf.format(fecha);
                                                                                      %>
                                                                                      <td><%=fechaNacimiento%></td> 
                                                                                      <% String email = emp.getEmail();%>
                                                                                      <td><%=email%></td> 
                                                                                     <% String cargo = emp.getCargo();%>
                                                                                      <td><%=cargo%></td>  
                                                                                     <% double sueldo = emp.getSueldo();%>
                                                                                      <td><%=sueldo%></td>  
                                                                                     <%int id = emp.getCodigo();%>
											<td>
                                                                                            <form name="frmBorrarEmpleado" action="SvModificarEmpleado" method="post">
                                                                                                <input type="hidden" name="id" value="<%=id%>">
                                                                                                <button type="submit" href="#!" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i></button>
                                                                                            </form>
                                                                                        </td>     
                                                                                           <td>
                                                                                               <form name="frmBorrarEmpleado" action="SvEliminarEmpleado"  method="post">
                                                                                                <input type="hidden" name="id" value="<%=id%>">
                                                                                                <button type="submit" href="#!" class="btn btn-danger btn-raised btn-xs"><i class="zmdi zmdi-delete"></i></button>
                                                                                            </form>
                                                                                        </td>
										</tr>
									</tbody>
                                                                        <%}%>
								</table>
								<ul class="pagination pagination-sm">
								  	<li class="disabled"><a href="#!">??</a></li>
								  	<li class="active"><a href="#!">1</a></li>
								  	<li><a href="#!">2</a></li>
								  	<li><a href="#!">3</a></li>
								  	<li><a href="#!">4</a></li>
								  	<li><a href="#!">5</a></li>
								  	<li><a href="#!">??</a></li>
								</ul>
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