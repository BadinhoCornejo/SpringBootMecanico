package com.badinho.SowadMecanico.repositories;

import com.badinho.SowadMecanico.models.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonal extends JpaRepository<Personal, Integer> {
}
