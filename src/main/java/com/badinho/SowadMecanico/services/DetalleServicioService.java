package com.badinho.SowadMecanico.services;

import com.badinho.SowadMecanico.models.DetalleServicio;
import com.badinho.SowadMecanico.repositories.IDetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleServicioService {

    @Autowired
    IDetalleServicio detalleServicioRepo;

    public List<DetalleServicio> list(){
        return detalleServicioRepo.findAll();
    }

    public DetalleServicio getByID(int servdtID){
        return detalleServicioRepo.findById(servdtID).get();
    }

    public DetalleServicio save(DetalleServicio detalleServicio){
        return detalleServicioRepo.save(detalleServicio);
    }

    public List<DetalleServicio> getByServmcID(int servmcID){ return detalleServicioRepo.findAllByServicioMecanicoServmcID(servmcID); }

    public void delete(int servdtID) { detalleServicioRepo.deleteById(servdtID); }

    public void deleteAll(List<DetalleServicio> detalleServicios){ detalleServicioRepo.deleteAll(detalleServicios);}
}
