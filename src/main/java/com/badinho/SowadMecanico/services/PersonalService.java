package com.badinho.SowadMecanico.services;

import com.badinho.SowadMecanico.models.Personal;
import com.badinho.SowadMecanico.repositories.IPersonal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalService {

    @Autowired
    IPersonal personalRepo;

    public List<Personal> list(){
        return personalRepo.findAll();
    }

    public Personal getByID(int personalID){
        return personalRepo.findById(personalID).get();
    }
}
