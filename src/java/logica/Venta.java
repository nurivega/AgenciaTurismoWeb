/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nurivega
 */
@Entity
public class Venta implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic
    private String medioPago;
    
    public Venta() {
    }

    public Venta(int codigo, Date fechaVenta, String medioPago) {
        this.codigo = codigo;
        this.fechaVenta = fechaVenta;
        this.medioPago = medioPago;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

   
}
