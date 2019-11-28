package com.badinho.SowadMecanico.services;

import com.badinho.SowadMecanico.models.UserMain;
import com.badinho.SowadMecanico.models.Usuario;
import com.badinho.SowadMecanico.repositories.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuario usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Usuario user = usuarioRepo.findByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("User not found");

        return new UserMain(user);
    }
}
