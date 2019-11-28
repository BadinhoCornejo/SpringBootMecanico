package com.badinho.SowadMecanico.restControllers;

import com.badinho.SowadMecanico.models.Roles;
import com.badinho.SowadMecanico.models.Usuario;
import com.badinho.SowadMecanico.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {

    @Autowired
    UsuarioService usuarioService;


    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @PostMapping(value = "new", consumes = "application/json", produces = "application/json")
    public Usuario addUser(@RequestBody Usuario usuario) {

        Roles role = new Roles();

        role.setRoleID(2);

        usuario.setRole(role);
        //Encrypt password
        usuario.setPassword(passwordEncoder().encode(usuario.getPassword()));

        return usuarioService.save(usuario);

    }

    @PostMapping(value = "login", consumes = "application/json", produces = "application/json")
    public Usuario iniciarSession(@RequestBody Usuario usuario) {
        Usuario _usuario = usuarioService.getByUsername(usuario.getUsername());

        Boolean auth = passwordEncoder().matches(usuario.getPassword(), _usuario.getPassword());

        if (!auth){
            return null;
        }

        return _usuario;
    }

    @GetMapping("checkUsername/{username}")
    public Usuario checkUsername(@PathVariable String username){
        Usuario usuario = usuarioService.getByUsername(username);

        return usuario;
    }
}
