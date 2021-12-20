/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author nurivega
 */
@Entity
public class Paquete implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    @Basic
    private double costo;
    @ManyToMany //mapeo JPA para relaciones n a n
    public List<Servicio> listaServicios; // 1 a n,  1 paquete puede tener muchos servicios. Relacion n a n entre paquete y servcio por lo cual en ambas clases tengo una relacion 1 a n. La lista va del lado del 1, al reves que en BD
    @OneToMany (cascade=CascadeType.REMOVE)
    private List<Venta> listaVentas;
    public Paquete() {
    }

    public Paquete(int codigo, double costo, List<Servicio> listaServicios, List<Venta> listaVentas) {
        this.codigo = codigo;
        this.costo = costo;
        this.listaServicios = listaServicios;
        this.listaVentas = listaVentas;
    }

    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public List<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(List<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
    
    

}
