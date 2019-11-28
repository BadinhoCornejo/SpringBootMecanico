package com.badinho.SowadMecanico.services;

import com.badinho.SowadMecanico.models.Roles;
import com.badinho.SowadMecanico.repositories.IRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {

    @Autowired
    IRoles rolesRepo;

    public List<Roles> list(){
        return rolesRepo.findAll();
    }
}
