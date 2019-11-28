package com.badinho.SowadMecanico.controllers;

import com.badinho.SowadMecanico.models.Roles;
import com.badinho.SowadMecanico.models.Usuario;
import com.badinho.SowadMecanico.services.UsuarioService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UsuarioService usuarioService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @RequestMapping(value = {"/","/login"},method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }

    @RequestMapping(value = "/registration-page", method = RequestMethod.GET)
    public String registration(Map<String, Object> model){
        Roles role = new Roles();
        role.setRoleID(2);
        Usuario usuario = new Usuario();
        usuario.setRole(role);
        model.put("usuario",usuario);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String newUser(@Valid Usuario usuario, BindingResult bindingResult, Map<String, Object> model){
        Usuario usuarioExists = usuarioService.getByUsername(usuario.getUsername());
        Roles role = new Roles();
        role.setRoleID(2);

        if(usuarioExists != null){
            bindingResult
                    .rejectValue("username", "error.usuario",
                            "Ya existe un usuario con este nombre de usuario");
        }
        if(bindingResult.hasErrors()){
            return "registration";
        }
        else{
            usuario.setRole(role);
            usuario.setPassword(passwordEncoder().encode(usuario.getPassword()));
            usuarioService.save(usuario);
            model.put("successMessage","Se registró al usuario");
            model.put("usuario",new Usuario());
            return "registration";
        }
    }
}
