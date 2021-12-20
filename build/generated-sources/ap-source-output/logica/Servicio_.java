package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Paquete;
import logica.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-20T15:08:21")
@StaticMetamodel(Servicio.class)
public class Servicio_ { 

    public static volatile SingularAttribute<Servicio, String> descripcion;
    public static volatile SingularAttribute<Servicio, Integer> codigo;
    public static volatile SingularAttribute<Servicio, Date> fechaInicio;
    public static volatile SingularAttribute<Servicio, Double> costo;
    public static volatile ListAttribute<Servicio, Paquete> listaPaquetes;
    public static volatile SingularAttribute<Servicio, String> destino;
    public static volatile ListAttribute<Servicio, Venta> listaVentas;
    public static volatile SingularAttribute<Servicio, String> nombre;

}