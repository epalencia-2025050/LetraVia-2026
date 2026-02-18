package com.codehunters.letravia.Controller;

import com.codehunters.letravia.service.AbecedarioService;
import org.springframework.web.bind.annotation.*;
import com.codehunters.letravia.Entity.Abecedario;

import java.util.List;

@RestController
@RequestMapping("/abecedario")
public class AbecedarioController {

    private final AbecedarioService service;

    public AbecedarioController(AbecedarioService service){
        this.service = service;
    }

    @GetMapping
    public List<Abecedario> listar(){
        return service.listar();
    }

    @PostMapping
    public Abecedario guardar(@RequestBody Abecedario letra){
        return  service.guardar(letra);
    }

    @GetMapping("/{letra}")
    public Abecedario buscar(@PathVariable String letra){
        return service.buscar(letra);
    }

    @DeleteMapping("/{letra}")
    public void eliminar(@PathVariable String letra){
        service.eliminar(letra);
    }

    @PutMapping("/{letra}")
    public Abecedario actualizar(@PathVariable String letra, @RequestBody Abecedario datosActualizados) {
        return service.actualizar(letra, datosActualizados);
    }



}