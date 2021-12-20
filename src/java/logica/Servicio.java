/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nurivega
 */
@Entity
public class Servicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic
    private String nombre;
    private String descripcion;
    private String destino;
    private double costo;
    @ManyToMany //mapeo JPA para relaciones n a n
    private List<Paquete> listaPaquetes; // 1 a n, 1 servicio puede estar en n paquetes. Relacion n a n entre paquete y servcio por lo cual en ambas clases tengo una relacion 1 a n
    @OneToMany (cascade=CascadeType.REMOVE)
    private List<Venta> listaVentas;
    
    public Servicio() {
    }

    public Servicio(int codigo, Date fechaInicio, String nombre, String descripcion, String destino, double costo, List<Paquete> listaPaquetes, List<Venta> listaVentas) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.destino = destino;
        this.costo = costo;
        this.listaPaquetes = listaPaquetes;
        this.listaVentas = listaVentas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public List<Paquete> getListaPaquetes() {
        return listaPaquetes;
    }

    public void setListaPaquetes(List<Paquete> listaPaquetes) {
        this.listaPaquetes = listaPaquetes;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

 
}
