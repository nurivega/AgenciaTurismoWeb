/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;
import java.util.List;
import persistencia.ControladoraPersistencia;

/**
 *
 * @author nurivega
 */
public class Controladora {


    ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();
    

    public void crearEmpleado(String nombre, String apellido, String direccion, String dni, String telefono, String nacionalidad, Date fechaNacimiento, String email, String cargo, Double sueldo, String usuario, String contrasenia) {
       Empleado empleado = new Empleado();
       Usuario usu = new Usuario();
       //asigno valores a un nuevo empleado
       empleado.setNombre(nombre);
       empleado.setApellido(apellido);
       empleado.setDireccion(direccion);
       empleado.setDni(dni);
       empleado.setCelular(telefono);
       empleado.setCargo(cargo);
       empleado.setSueldo(sueldo);
       empleado.setEmail(email);
       empleado.setFechaNacimiento(fechaNacimiento);
       empleado.setNacionalidad(nacionalidad);
       //asigno valores al nuevo usuario
       usu.setNombre(usuario);
       usu.setContrasenia(contrasenia);
       
       //asigno el usuario al empleado
       empleado.setUsuario(usu);
       
       controladoraPersistencia.crearEmpleado(empleado, usu);
    }
     

    public void crearCliente(String nombre, String apellido, String direccion, String dni, String telefono, String nacionalidad, Date fechaNacimiento, String email) {
       Cliente cliente = new Cliente();
       
       cliente.setNombre(nombre);
       cliente.setApellido(apellido);
       cliente.setDireccion(direccion);
       cliente.setDni(dni);
       cliente.setCelular(telefono);
       cliente.setEmail(email);
       cliente.setFechaNacimiento(fechaNacimiento);
       cliente.setNacionalidad(nacionalidad);
       
       controladoraPersistencia.crearCliente(cliente);
    }
    
      public void crearServicio(String nombre, String descripcion, String destino, double costo, Date fechaSalida) {
        Servicio servicio = new Servicio();
        servicio.setCosto(costo);
        servicio.setDescripcion(descripcion);
        servicio.setFechaInicio(fechaSalida);
        servicio.setNombre(nombre);
        servicio.setDestino(destino);
        
        controladoraPersistencia.crearServicio(servicio);
    }
      public  Venta crearVenta(String medioPago, Date fechaVenta) {
        Venta venta = new Venta();
        venta.setMedioPago(medioPago);
        venta.setFechaVenta(fechaVenta);
        int id = controladoraPersistencia.crearVenta(venta);
        venta.setCodigo(id);
        return venta;
    }
      
    public void crearPaquete(double precio, List<Servicio> servicios) {
        Paquete paquete = new Paquete();
        paquete.setCosto(precio);
        paquete.setListaServicios(servicios);
        controladoraPersistencia.crearPaquete(paquete);
    }


     public List<Empleado> listarEmpleados(){
        return controladoraPersistencia.listarEmpleados();
    }
     
    public List<Cliente> listarClientes(){
        return controladoraPersistencia.listarClientes();
    }

    public List<Venta> listarVentas(){
        return controladoraPersistencia.listarVentas();
    }
      public List<Usuario> listarUsuarios(){
        return controladoraPersistencia.listarUsuarios();
    }
    
      public List<Paquete> listarPaquetes(){
        return controladoraPersistencia.listarPaquetes();
    }
      
      public List<Servicio> listarServicio(){
        return controladoraPersistencia.listarServicios();
    }
    

    public boolean verificarUsuario(String usuario, String contrasenia) {
        List<Usuario> listaUsuarios = controladoraPersistencia.listarUsuarios();
        if(listaUsuarios != null){
            for(Usuario usu : listaUsuarios){
                if(usu.getNombre().equals(usuario) && usu.getContrasenia().equals(contrasenia)){
                    return true;
                } 
            }
        }
        return false;
    }
    
    public int obtenerUsuario(int idEmpleado){
        //declaro el empleado
        Empleado empleado = new Empleado();
        //busco el empleado con el id correspondiente
        empleado = controladoraPersistencia.obtenerEmpleado(idEmpleado);
        //busco el usuario del empleado
        Usuario usuario= empleado.getUsuario();
        //obtengo el id del usuario
        int idUsuario = usuario.getCodigo();
        return idUsuario;
    }
    
    public Empleado obtenerEmpleado(int id) {
        return controladoraPersistencia.obtenerEmpleado(id);
    }
    
    public Servicio obtenerServicio(int idServicio) {
       return controladoraPersistencia.obtenerServicio(idServicio);
    }
    public Paquete obtenerPaquete(int idPaquete) {
       return controladoraPersistencia.obtenerPaquete(idPaquete);
    }
    public Venta obtenerVenta(int idVenta) {
       return controladoraPersistencia.obtenerVenta(idVenta);
    }
    
    public Cliente obtenerCliente(int idCliente) {
        return controladoraPersistencia.obtenerCliente(idCliente);
    }
    
    public void eliminarEmpleado(int idEmpleado) {
        int idUsuario = obtenerUsuario(idEmpleado);
        controladoraPersistencia.eliminarEmpleado(idEmpleado);
        controladoraPersistencia.eliminarUsuario(idUsuario);
    }
    
    public void eliminarCliente(int idCliente) {
        controladoraPersistencia.eliminarCliente(idCliente);
    }
    
    public void eliminarServicio(int idServicio) {
        controladoraPersistencia.eliminarServicio(idServicio);
    }
     
    public void eliminarPaquete(int idPaquete) {
        controladoraPersistencia.eliminarPaquete(idPaquete);
    }
    
    public void eliminarVenta(int idVenta) {
        controladoraPersistencia.eliminarVenta(idVenta);
    }

    public void modificarEmpleado(Empleado empleado) {
        controladoraPersistencia.modificarEmpleado(empleado);
    }
    public void modificarUsuario(Usuario usuario) {
        controladoraPersistencia.modificarUsuario(usuario);
    }


    public void modificarServicio(Servicio s) {
        controladoraPersistencia.modificarServicio(s);
    }


    public void modificarCliente(Cliente cliente) {
       controladoraPersistencia.modificarCliente(cliente);
    }

    public void modificarPaquete(Paquete paquete) {
        controladoraPersistencia.modificarPaquete(paquete);
    }

    public Usuario obtenerUsuarioUnico(int idUsuario) {
       return controladoraPersistencia.obtenerUsuario(idUsuario);
    }

    public int obtenerCodigoUsuario(String usuario, String contrasenia) {
        int codigoUsuario = 0;
        List<Usuario> listaUsuarios = controladoraPersistencia.listarUsuarios();
        if(listaUsuarios != null){
            for(Usuario usu : listaUsuarios){
                if(usu.getNombre().equals(usuario) && usu.getContrasenia().equals(contrasenia)){
                    codigoUsuario = usu.getCodigo();
                } 
            }
        }
        return codigoUsuario;
    }



 


 

    
    
  
}
