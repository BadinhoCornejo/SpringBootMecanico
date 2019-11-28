package com.badinho.SowadMecanico.controllers;

import com.badinho.SowadMecanico.models.*;
import com.badinho.SowadMecanico.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/servicio")
public class ServicioController {

    @Autowired
    ServicioService servicioService;

    @Autowired
    ServicioMecanicoService servicioMecanicoService;

    @Autowired
    DetalleServicioService detalleServicioService;

    @Autowired
    PersonalService personalService;

    @Autowired
    ClienteService clienteService;



    @RequestMapping(value="/", method = RequestMethod.GET)
    public String nuevoServicio(Map<String, Object> model){

        ServicioMecanico servicioMecanico = new ServicioMecanico();

        List<Personal> personalList = personalService.list();
        List<Cliente> clienteList = clienteService.list();

        model.put("servicio", servicioMecanico);
        model.put("personalList", personalList);
        model.put("clienteList", clienteList);

        return "admin/nuevoServicio";
    }

    @PostMapping("nuevoServicio")
    public String nuevoServicioPost(ServicioMecanico servicioMecanico){
        ServicioMecanico _serMecanico = servicioMecanicoService.save(servicioMecanico);

        String returnUrl = "redirect:/admin/servicio/agregarDetalle/"
                + servicioMecanicoService.getByFecha(_serMecanico.getFecha()).getServmcID();

        return returnUrl;
    }

    @GetMapping("agregarDetalle/{servmcID}")
    public String agregarDetalle(@PathVariable(value = "servmcID") int servmcID, Map<String, Object> model){

        DetalleServicio detalleServicio = new DetalleServicio();

        ServicioMecanico servicioMecanico = servicioMecanicoService.getByID(servmcID);

        detalleServicio.setServicioMecanico(servicioMecanico);

        List<Servicio> servicios = servicioService.list();

        model.put("servicios", servicios);
        model.put("detalleServicio", detalleServicio);

        return "admin/agregarDetalle";
    }

    @PostMapping("agregarDetalle")
    public String agregarDetallePost(DetalleServicio detalleServicio){
        DetalleServicio _detalleServicio = detalleServicioService.save(detalleServicio);

        return "redirect:/admin/servicio/servicios";
    }

    @GetMapping("editarDetalle/{servdtID}")
    public String editarDetalle(@PathVariable(value = "servdtID")int servdtID, Map<String, Object> model){
        DetalleServicio detalleServicio = detalleServicioService.getByID(servdtID);
        List<Servicio> servicios = servicioService.list();

        model.put("servicios", servicios);
        model.put("detalleServicio",detalleServicio);

        return "admin/editarServicio";
    }

    @PostMapping("editarDetalle")
    public String editarDetallePost(DetalleServicio detalleServicio){
        DetalleServicio _deServicio = detalleServicioService.save(detalleServicio);

        return "redirect:/admin/servicio/servicios";
    }

    @GetMapping("eliminarServicio/{servdtID}")
    public String eliminarServicio(@PathVariable(value = "servdtID") int servdtID){

        DetalleServicio detalleServicio = detalleServicioService.getByID(servdtID);

        ServicioMecanico servicioMecanico = detalleServicio.getServicioMecanico();

        detalleServicioService.delete(servdtID);

        List<DetalleServicio> detalleServicios = detalleServicioService.getByServmcID(servicioMecanico.getServmcID());

        if (detalleServicios.isEmpty()){
            servicioMecanicoService.delete(servicioMecanico.getServmcID());
        }

        return "redirect:/admin/servicio/servicios";
    }



    @GetMapping("servicios")
    public String serviciosLista(Model model){
        List<DetalleServicio> detalleServicios = detalleServicioService.list();

        model.addAttribute("servicios", detalleServicios);

        return "admin/servicios";
    }

}
