package com.badinho.SowadMecanico.restControllers;

import com.badinho.SowadMecanico.models.Cliente;
import com.badinho.SowadMecanico.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/cliente")
public class ClienteRestController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("listaCliente")
    public List<Cliente> clienteList(){return clienteService.list();}
}
