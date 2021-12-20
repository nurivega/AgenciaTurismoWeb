
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cliente;
import logica.Empleado;
import logica.Paquete;
import logica.Servicio;
import logica.Usuario;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    ClienteJpaController clienteJpa = new ClienteJpaController();
    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();
    PaqueteJpaController paqueteJpa = new PaqueteJpaController();
    ServicioJpaController servicioJpa = new ServicioJpaController();
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    VentaJpaController ventaJpa = new VentaJpaController();

    public void crearEmpleado(Empleado empleado, Usuario usu) {
       usuarioJpa.create(usu);
       empleadoJpa.create(empleado);
    }
    
     public void crearCliente(Cliente cliente) {
       clienteJpa.create(cliente);
    }
    
    
     public void crearServicio(Servicio servicio) {
       servicioJpa.create(servicio);
    }
  
    
    public Paquete crearPaquete(Paquete paquete) {
       return paqueteJpa.create(paquete);
    }
    
   public int crearVenta(Venta venta) {
       int id = 0;
       try {
           id=  ventaJpa.create(venta);
           return id;
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
      return id;
    }
    
    public List<Usuario> listarUsuarios() {
      return usuarioJpa.findUsuarioEntities();
    }
    
    public List<Venta> listarVentas() {
      return ventaJpa.findVentaEntities();
    }
    
    public List<Empleado> listarEmpleados(){
        return empleadoJpa.findEmpleadoEntities();
    }
    
    public List<Cliente> listarClientes(){
        return clienteJpa.findClienteEntities();
    }
    
    public List<Servicio> listarServicios(){
        return servicioJpa.findServicioEntities();
    }
    
     public List<Paquete> listarPaquetes(){
        return paqueteJpa.findPaqueteEntities();
    }

    public void eliminarEmpleado(int id) {
        try {
            empleadoJpa.destroy(id);
            
        } catch (NonexistentEntityException e) {
        }
    }

    public void eliminarUsuario(int idUsuario) {
         try {
            usuarioJpa.destroy(idUsuario);
        } catch (NonexistentEntityException e) {
        }
    }
    
     public void eliminarServicio(int idServicio) {
         try {
            servicioJpa.destroy(idServicio);
        } catch (NonexistentEntityException e) {
        }
    }
     
      public void eliminarPaquete(int idPaquete) {
         try {
            paqueteJpa.destroy(idPaquete);
        } catch (NonexistentEntityException e) {
        }
    }
    
     public void eliminarCliente(int idCliente) {
         try {
            clienteJpa.destroy(idCliente);
        } catch (NonexistentEntityException e) {
        }
    }
    public void eliminarVenta(int idVenta) {
         try {
            ventaJpa.destroy(idVenta);
        } catch (NonexistentEntityException e) {
        }
    }
    
    public Empleado obtenerEmpleado(int idEmpleado) {
       return empleadoJpa.findEmpleado(idEmpleado);
    }

    public void modificarEmpleado(Empleado empleado) {
        try {
            empleadoJpa.edit(empleado);
        } catch (Exception e) {
        }
    }
    
     public void modificarUsuario(Usuario usuario) {
        try {
            usuarioJpa.edit(usuario);
        } catch (Exception e) {
        }
    }

    public Servicio obtenerServicio(int idServicio) {
        return servicioJpa.findServicio(idServicio);
    }

    public Cliente obtenerCliente(int idCliente) {
       return clienteJpa.findCliente(idCliente);
    }

    public Venta obtenerVenta(int idVenta) {
        return ventaJpa.findVenta(idVenta);
    }

    public void modificarServicio(Servicio s) {
        try {
            servicioJpa.edit(s);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void modificarCliente(Cliente cliente) {
        try {
            
            clienteJpa.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    public void modificarPaquete(Paquete paquete) {
        try {
            paqueteJpa.edit(paquete);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Paquete obtenerPaquete(int idPaquete) {
       return paqueteJpa.findPaquete(idPaquete);
    }

    public Usuario obtenerUsuario(int idUsuario) {
      return usuarioJpa.findUsuario(idUsuario);
    }

   

    
}
