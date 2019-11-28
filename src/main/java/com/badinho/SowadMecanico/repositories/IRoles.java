package com.badinho.SowadMecanico.repositories;

import com.badinho.SowadMecanico.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoles extends JpaRepository<Roles, Integer> {
}
