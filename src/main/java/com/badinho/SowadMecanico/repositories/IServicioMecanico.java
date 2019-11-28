package com.badinho.SowadMecanico.repositories;

import com.badinho.SowadMecanico.models.ServicioMecanico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IServicioMecanico extends JpaRepository<ServicioMecanico, Integer> {
    public ServicioMecanico findByFecha(Date fecha);
}
