package com.codehunters.letravia.Controller;

import com.codehunters.letravia.Repository.ProgresoRepository;
import com.codehunters.letravia.Entity.Progreso;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/Progreso", "/Menu/Progreso"})
public class ProgresoController {

    private final ProgresoRepository repo;

    public ProgresoController(ProgresoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Progreso> listar() {
        return repo.findAll();
    }


    @GetMapping("/{id}")
    public Progreso obtener(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }


    @PostMapping
    public Progreso crear(@RequestBody Progreso progreso) {
        return repo.save(progreso);
    }

    @PutMapping("/{id}")
    public Progreso actualizar(@PathVariable Long id, @RequestBody Progreso nuevo) {
        Progreso progreso = repo.findById(id).orElse(null);

        if (progreso != null) {
            progreso.setPorcentaje(nuevo.getPorcentaje());
            progreso.setEstado(nuevo.getEstado());
            progreso.setPuntos(nuevo.getPuntos());
            progreso.setClienteId(nuevo.getClienteId());
            progreso.setLecturaId(nuevo.getLecturaId());
            return repo.save(progreso);
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}