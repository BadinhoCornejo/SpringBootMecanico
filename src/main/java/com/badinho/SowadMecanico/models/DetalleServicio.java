package com.badinho.SowadMecanico.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "detalleservicio")
@Table(name = "detalleservicio")
public class DetalleServicio implements Serializable {

    private int servdtID;
    private ServicioMecanico servicioMecanico;
    private Servicio servicio;
    private String marca;
    private String modelo;
    private String placa;
    private String contenido;

    @Id
    @Column(name = "servdtID")
    public int getServdtID() {
        return servdtID;
    }

    public void setServdtID(int servdtID) {
        this.servdtID = servdtID;
    }

    @ManyToOne
    @JoinColumn(name = "servmcID", referencedColumnName = "servmcID")
    public ServicioMecanico getServicioMecanico() {
        return servicioMecanico;
    }

    public void setServicioMecanico(ServicioMecanico servicioMecanico) {
        this.servicioMecanico = servicioMecanico;
    }

    @ManyToOne
    @JoinColumn(name = "servicioID", referencedColumnName = "servicioID")
    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Column(name = "marca")
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Column(name = "modelo")
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Column(name = "placa")
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Column(name = "contenido")
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
