package com.badinho.SowadMecanico.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "serviciossolicitados")
@Table(name = "serviciossolicitados")
public class ServiciosSolicitados implements Serializable {

    private int servsoID;
    private Servicio servicio;
    private Cliente cliente;
    private Date fecha;

    @Id
    @Column(name = "servsoID")
    public int getServsoID() {
        return servsoID;
    }

    public void setServsoID(int servsoID) {
        this.servsoID = servsoID;
    }

    @ManyToOne
    @JoinColumn(name = "servicioID", referencedColumnName = "servicioID")
    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @ManyToOne
    @JoinColumn(name = "clienteID", referencedColumnName = "clienteID")
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Column(name = "fecha")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
