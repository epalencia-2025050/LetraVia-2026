package com.codehunters.letravia.Controller;

import com.codehunters.letravia.Repository.LecturasRepository;
import com.codehunters.letravia.Entity.Lecturas;
import com.codehunters.letravia.service.LecturasService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/lecturas", "/Menu/lecturas"})
public class LecturasController {

    private LecturasService lecturasService;

    public LecturasController(LecturasService lecturasService) {
        this.lecturasService = lecturasService;
    }

    @PostMapping public Lecturas crear(@RequestBody Lecturas lectura) {
        return lecturasService.crearLectura(lectura);
    }

    @GetMapping public List<Lecturas> listar() {
        return lecturasService.obtenerTodas();
    }

    @GetMapping("/{id}") public Lecturas obtener(@PathVariable Long id) {
        return lecturasService.obtenerPorId(id);
    }

    @PutMapping("/{id}") public Lecturas actualizar(@PathVariable Long id, @RequestBody Lecturas lectura) {
        return lecturasService.actualizarLectura(id, lectura);
    }

    @DeleteMapping("/{id}") public void eliminar(@PathVariable Long id) {
        lecturasService.eliminarLectura(id);
    }
}
