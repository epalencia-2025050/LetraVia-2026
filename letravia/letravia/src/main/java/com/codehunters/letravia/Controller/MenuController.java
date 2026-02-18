package com.codehunters.letravia.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/Menu")
public class MenuController {

    @GetMapping
    public Map<String, String> mostrarMenu() {

        Map<String, String> menu = new LinkedHashMap<>();
        menu.put("Seleccione la seccion", "Que quiere trabajar");
        menu.put("opcion1", "/Menu/cliente");
        menu.put("opcion2", "/Menu/Abcdario");
        menu.put("opcion3", "/Menu/Lecturas");
        menu.put("opcion4", "/Menu/Progreso");
        menu.put("salir", "/menu/salir");

        return menu;
    }

}
