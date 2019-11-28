package com.badinho.SowadMecanico.restControllers;

import com.badinho.SowadMecanico.models.DetalleServicio;
import com.badinho.SowadMecanico.models.Servicio;
import com.badinho.SowadMecanico.models.ServicioMecanico;
import com.badinho.SowadMecanico.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicio")
public class ServicioRestController {

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

    @PostMapping(value = "agregarServicio", consumes = "application/json", produces = "application/json")
    public ServicioMecanico agregarServicio(@RequestBody ServicioMecanico servicioMecanico){
        return servicioMecanicoService.save(servicioMecanico);
    }

    @GetMapping(value = "buscarSrvMecanico/{servmcID}")
    public ServicioMecanico buscarSrvMecanico(@PathVariable("servmcID")int servmcID){
        return servicioMecanicoService.getByID(servmcID);
    }

     @GetMapping(value = "buscarDetalle/{servdtID}")
     public DetalleServicio buscarDetalle(@PathVariable("servdtID")int servdtID){
        return detalleServicioService.getByID(servdtID);
     }

    @PostMapping(value = "eliminarServicios")
    public Boolean eliminarServicio(@RequestBody List<DetalleServicio> detalleServicios){

        Boolean response;

        List<DetalleServicio> _detalleServicios = detalleServicios;

        try {
            detalleServicioService.deleteAll(_detalleServicios);
            for (DetalleServicio detalleServicio: detalleServicios
                 ) {
                ServicioMecanico servicioMecanico = detalleServicio.getServicioMecanico();
                if(servicioMecanico != null)
                {
                    List<DetalleServicio> detalleServiciosFromServicio = detalleServicioService.getByServmcID(servicioMecanico.getServmcID());
                    if (detalleServiciosFromServicio.isEmpty()){
                        servicioMecanicoService.delete(servicioMecanico.getServmcID());
                    }
                }
            }
            response = true;
        }catch (Exception e){
            response = false;
        }
        return response;
    }

    @PostMapping(value = "agregarDetalle", consumes = "application/json", produces = "application/json")
    public DetalleServicio agregarDetalle(@RequestBody DetalleServicio detalleServicio){
        return detalleServicioService.save(detalleServicio);
    }

    @PutMapping(value = "editarServicio", consumes = "application/json", produces = "application/json")
    public DetalleServicio editarDetalle(@RequestBody DetalleServicio detalleServicio){
        return detalleServicioService.save(detalleServicio);
    }

    @GetMapping("serviciosDetalle")
    public List<DetalleServicio> serviciosDetalle(){
        return detalleServicioService.list();
    }

    @GetMapping("servicios")
    public List<Servicio> servicios()
    {
        return servicioService.list();
    }

    @PostMapping("servicioByFecha")
    public ServicioMecanico servicioMecanicoByFecha(@RequestBody ServicioMecanico servicioMecanico){
        return servicioMecanicoService.getByFecha(servicioMecanico.getFecha());
    }

}
