package com.badinho.SowadMecanico.services;

import com.badinho.SowadMecanico.models.Servicio;
import com.badinho.SowadMecanico.repositories.IServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {

    @Autowired
    IServicio servicioRepo;

    public List<Servicio> list(){
        return servicioRepo.findAll();
    }

    public Servicio getByID(int servicioID){
        return servicioRepo.findById(servicioID).get();
    }

    public Servicio save(Servicio servicio){
        return servicioRepo.save(servicio);
    }
}
