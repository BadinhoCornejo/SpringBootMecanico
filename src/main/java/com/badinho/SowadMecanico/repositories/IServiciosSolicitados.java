package com.badinho.SowadMecanico.repositories;

import com.badinho.SowadMecanico.models.ServiciosSolicitados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiciosSolicitados extends JpaRepository<ServiciosSolicitados, Integer> {
}
