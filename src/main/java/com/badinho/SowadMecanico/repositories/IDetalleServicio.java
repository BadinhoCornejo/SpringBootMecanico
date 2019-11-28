package com.badinho.SowadMecanico.repositories;

import com.badinho.SowadMecanico.models.DetalleServicio;
import com.badinho.SowadMecanico.models.ServicioMecanico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetalleServicio extends JpaRepository<DetalleServicio, Integer> {

    public List<DetalleServicio> findAllByServicioMecanicoServmcID(int servmcID);
}
