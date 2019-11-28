package com.badinho.SowadMecanico.services;

import com.badinho.SowadMecanico.models.ServiciosSolicitados;
import com.badinho.SowadMecanico.repositories.IServiciosSolicitados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosSolicitadosService {

    @Autowired
    IServiciosSolicitados serviciosSolicitadosRepo;

    public List<ServiciosSolicitados> list(){
        return serviciosSolicitadosRepo.findAll();
    }

    public ServiciosSolicitados getByID(int servsoID){
        return serviciosSolicitadosRepo.findById(servsoID).get();
    }

    public ServiciosSolicitados save(ServiciosSolicitados serviciosSolicitados){
        return serviciosSolicitadosRepo.save(serviciosSolicitados);
    }
}
