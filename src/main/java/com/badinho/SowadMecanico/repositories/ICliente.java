package com.badinho.SowadMecanico.repositories;

import com.badinho.SowadMecanico.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICliente extends JpaRepository<Cliente, Integer> {
}
