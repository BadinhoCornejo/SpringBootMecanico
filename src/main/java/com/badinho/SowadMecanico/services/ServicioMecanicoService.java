package com.badinho.SowadMecanico.services;

import com.badinho.SowadMecanico.models.ServicioMecanico;
import com.badinho.SowadMecanico.repositories.IServicioMecanico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ServicioMecanicoService {

    @Autowired
    IServicioMecanico servicioMecanicoRepo;

    public List<ServicioMecanico> list(){
        return servicioMecanicoRepo.findAll();
    }

    public ServicioMecanico getByID(int servmcID){
        return servicioMecanicoRepo.findById(servmcID).get();
    }

    public ServicioMecanico getByFecha(Date fecha){
        return servicioMecanicoRepo.findByFecha(fecha);
    }

    public ServicioMecanico save(ServicioMecanico servicioMecanico){
        return servicioMecanicoRepo.save(servicioMecanico);
    }

    public void delete(int servmcID){ servicioMecanicoRepo.deleteById(servmcID); }
}
