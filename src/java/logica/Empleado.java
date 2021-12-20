/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author nurivega
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="codigo")
public class Empleado extends Persona implements Serializable{
    @Basic
    private String cargo;
    private double sueldo;
    @OneToOne // relacion 1 a 1 con usuario
    private Usuario usuario;
    @OneToMany (cascade=CascadeType.REMOVE) //relacion 1 a n. La lsita va del lado del 1, al contrario que en BD
    private List<Venta> listaVentas;

    public Empleado() {
    }

 
    public Empleado(String cargo, double sueldo, Usuario usuario, List<Venta> listaVentas, int codigo, String nombre, String apellido, String direccion, String dni, java.sql.Date fechaNacimiento, String nacionalidad, String celular, String email) {
        super(codigo, nombre, apellido, direccion, dni, fechaNacimiento, nacionalidad, celular, email);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.usuario = usuario;
        this.listaVentas = listaVentas;
    }

    public Empleado(String cargo, double sueldo, Usuario usuario, int codigo, String nombre, String apellido, String direccion, String dni, java.sql.Date fechaNacimiento, String nacionalidad, String celular, String email) {
        super(codigo, nombre, apellido, direccion, dni, fechaNacimiento, nacionalidad, celular, email);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.usuario = usuario;
    }
    
    

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

  
    
}
