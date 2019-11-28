package com.badinho.SowadMecanico.services;

import com.badinho.SowadMecanico.models.Usuario;
import com.badinho.SowadMecanico.repositories.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    IUsuario usuarioRepo;

    public Usuario getByUsername(String username){
        return usuarioRepo.findByUsername(username);
    }

    public Usuario save(Usuario usuario){
        return usuarioRepo.save(usuario);
    }
}
