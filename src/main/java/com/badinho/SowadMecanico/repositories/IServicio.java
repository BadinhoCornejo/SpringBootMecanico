package com.badinho.SowadMecanico.repositories;

import com.badinho.SowadMecanico.models.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServicio extends JpaRepository<Servicio, Integer> {
}
