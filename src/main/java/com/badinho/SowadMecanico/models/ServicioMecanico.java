package com.badinho.SowadMecanico.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "serviciomecanico")
@Table(name = "serviciomecanico")
public class ServicioMecanico implements Serializable {

    private int servmcID;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date fecha;
    private Personal personal;
    private Cliente cliente;

    @Id
    @Column(name = "servmcID")
    public int getServmcID() {
        return servmcID;
    }

    public void setServmcID(int servmcID) {
        this.servmcID = servmcID;
    }

    @Column(name = "fecha")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @ManyToOne
    @JoinColumn(name = "personalID", referencedColumnName = "personalID")
    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @ManyToOne
    @JoinColumn(name = "clienteID", referencedColumnName = "clienteID")
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
