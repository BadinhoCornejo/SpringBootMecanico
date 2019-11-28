package com.badinho.SowadMecanico.repositories;

import com.badinho.SowadMecanico.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuario extends JpaRepository<Usuario, Integer> {
    public Usuario findByUsername(String username);
}
