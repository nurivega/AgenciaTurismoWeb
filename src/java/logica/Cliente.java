/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author nurivega
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="codigo")
public class Cliente extends Persona implements Serializable{

    @OneToMany (cascade=CascadeType.REMOVE)
    private List<Venta> comprasCliente;
    
    public Cliente() {
    }

    public Cliente(int codigo, String nombre, String apellido, String direccion, String dni, Date fechaNacimiento, String nacionalidad, String celular, String email) {
        super(codigo, nombre, apellido, direccion, dni, fechaNacimiento, nacionalidad, celular, email);
    }
    
    

    public Cliente(List<Venta> comprasCliente, int codigo, String nombre, String apellido, String direccion, String dni, Date fechaNacimiento, String nacionalidad, String celular, String email) {
        super(codigo, nombre, apellido, direccion, dni, fechaNacimiento, nacionalidad, celular, email);
        this.comprasCliente = comprasCliente;
    }



    public List<Venta> getComprasCliente() {
        return comprasCliente;
    }

    public void setComprasCliente(List<Venta> comprasCliente) {
        this.comprasCliente = comprasCliente;
    }
  
}
