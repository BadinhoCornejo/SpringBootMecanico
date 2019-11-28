package com.badinho.SowadMecanico.restControllers;

import com.badinho.SowadMecanico.models.Personal;
import com.badinho.SowadMecanico.services.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/personal")
public class PersonalRestController {
    @Autowired
    PersonalService personalService;

    @GetMapping("listaPersonal")
    public List<Personal> personalList(){return personalService.list();}
}
