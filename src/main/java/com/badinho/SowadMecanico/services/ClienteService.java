package com.badinho.SowadMecanico.services;

import com.badinho.SowadMecanico.models.Cliente;
import com.badinho.SowadMecanico.repositories.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    ICliente clienteRepo;

    public List<Cliente> list(){
        return clienteRepo.findAll();
    }

    public Cliente getByID(int clienteID){
        return clienteRepo.findById(clienteID).get();
    }
}
