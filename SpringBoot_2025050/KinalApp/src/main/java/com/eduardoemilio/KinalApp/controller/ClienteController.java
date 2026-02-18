package com.eduardoemilio.KinalApp.controller;

import com.eduardoemilio.KinalApp.entity.Cliente;
import com.eduardoemilio.KinalApp.repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository repo;

    public ClienteController(ClienteRepository repo){
        this.repo = repo;
    }
    @GetMapping
    public List<Cliente> listar(){
        return repo.findAll();
    }

    @PostMapping
    public Cliente guardar(@RequestBody Cliente c){
         return repo.save(c);
    }

    @PutMapping("/user{id}")
    public Cliente actualizar(@PathVariable Cliente c){
        return repo.save(c);
    }

}
