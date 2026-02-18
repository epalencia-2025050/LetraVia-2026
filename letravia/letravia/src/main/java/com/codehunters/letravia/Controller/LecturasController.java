package com.codehunters.letravia.Controller;

import com.codehunters.letravia.Repository.LecturasRepository;
import com.codehunters.letravia.Entity.Lecturas;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/lecturas", "/Menu/lecturas"})
public class LecturasController {

    private final LecturasRepository repo;

    public LecturasController(LecturasRepository repo){
        this.repo = repo;
    }

    @GetMapping
    public List<Lecturas> listarLecturas(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Lecturas obtenerLectura(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Lecturas crearLectura(@RequestBody Lecturas lectura) {
        return repo.save(lectura);
    }


}
