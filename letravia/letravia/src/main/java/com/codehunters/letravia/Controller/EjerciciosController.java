package com.codehunters.letravia.Controller;

import com.codehunters.letravia.Entity.Ejercicios;
import com.codehunters.letravia.Repository.EjerciciosRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({"/ejercicios", "/Menu/ejercicios"})
public class EjerciciosController {

    private final EjerciciosRepository repo;

    public EjerciciosController(EjerciciosRepository repo) {
        this.repo = repo;
    }


    @GetMapping
    public List<Ejercicios> listar() {
        return repo.findAll();
    }


    @GetMapping("/{id}")
    public Ejercicios obtener(@PathVariable Integer id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Ejercicios crear(@RequestBody Ejercicios ejercicio) {
        return repo.save(ejercicio);
    }


    @PutMapping("/{id}")
    public Ejercicios actualizar(@PathVariable Integer id, @RequestBody Ejercicios nuevo) {
        Ejercicios ejercicio = repo.findById(id).orElse(null);

        if (ejercicio != null) {
            ejercicio.setPregunta(nuevo.getPregunta());
            ejercicio.setOpcion1(nuevo.getOpcion1());
            ejercicio.setOpcion2(nuevo.getOpcion2());
            ejercicio.setOpcion3(nuevo.getOpcion3());
            ejercicio.setOpcionCorrecta(nuevo.getOpcionCorrecta());
            ejercicio.setGrupo(nuevo.getGrupo());
            return repo.save(ejercicio);
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        repo.deleteById(id);
    }


    @GetMapping("/grupo/{grupo}")
    public List<Ejercicios> listarPorGrupo(@PathVariable String grupo) {
        return repo.findAll().stream()
                .filter(e -> e.getGrupo().equalsIgnoreCase(grupo))
                .toList();
    }


    @GetMapping("/lectura1")
    public String lectura1() {
        return """
        Lectura 1 – Ejercicio
        ¿Qué tenía Luis?
        
        Seleccione la respuesta correcta:
        A → /Menu/ejercicios/lectura1/A
        B → /Menu/ejercicios/lectura1/B
        C → /Menu/ejercicios/lectura1/C
        """;
    }

    @GetMapping("/lectura1/A")
    public String lectura1A() {
        return "Incorrecto. Revisa la lectura 1.";
    }

    @GetMapping("/lectura1/B")
    public String lectura1B() {
        return "Correcto. Excelente comprensión.";
    }

    @GetMapping("/lectura1/C")
    public String lectura1C() {
        return "Incorrecto. Intenta nuevamente.";
    }


    @GetMapping("/lectura2")
    public String lectura2() {
        return """
        Lectura 2 – Ejercicio
        ¿A qué hora se despertó Ana?
        
        Seleccione la respuesta correcta:
        A → /Menu/ejercicios/lectura2/A
        B → /Menu/ejercicios/lectura2/B
        C → /Menu/ejercicios/lectura2/C
        """;
    }

    @GetMapping("/lectura2/A")
    public String lectura2A() {
        return "Correcto. Muy bien.";
    }

    @GetMapping("/lectura2/B")
    public String lectura2B() {
        return "Incorrecto. Vuelve a leer el texto.";
    }

    @GetMapping("/lectura2/C")
    public String lectura2C() {
        return "Incorrecto. No es la opción correcta.";
    }


    @GetMapping("/lectura3")
    public String lectura3() {
        return """
        Lectura 3 – Ejercicio
        ¿A quién visitó Carlos?

        Seleccione la respuesta correcta:
        A → /Menu/ejercicios/lectura3/A
        B → /Menu/ejercicios/lectura3/B
        C → /Menu/ejercicios/lectura3/C
        """;
    }

    @GetMapping("/lectura3/A")
    public String lectura3A() {
        return "Incorrecto. Analiza mejor la lectura.";
    }

    @GetMapping("/lectura3/B")
    public String lectura3B() {
        return "Incorrecto. No coincide con el texto.";
    }

    @GetMapping("/lectura3/C")
    public String lectura3C() {
        return "Correcto. Buen trabajo.";
    }
}
