package com.badinho.SowadMecanico.controllers;

import com.badinho.SowadMecanico.models.Usuario;
import com.badinho.SowadMecanico.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value ="/admin/home", method = RequestMethod.GET)
    public String home(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = usuarioService.getByUsername(auth.getName());

        model.addAttribute("usuario",usuario);

        return "admin/home";
    }
}
