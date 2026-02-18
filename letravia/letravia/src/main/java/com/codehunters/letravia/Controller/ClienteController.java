package com.codehunters.letravia.Controller;

import com.codehunters.letravia.Repository.ClienteRepository;
import com.codehunters.letravia.Repository.LecturasRepository;
import com.codehunters.letravia.Entity.Cliente;
import com.codehunters.letravia.Entity.Lecturas;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping({"/cliente", "/Menu/cliente"})
public class ClienteController {

    private final ClienteRepository clienteRepo;
    private final LecturasRepository lecturaRepo;

    public ClienteController(ClienteRepository repo, LecturasRepository lecturaRepo){
        this.clienteRepo = repo;
        this.lecturaRepo = lecturaRepo;
    }
    @GetMapping
    public List<Cliente> listar(){
        return clienteRepo.findAll();
    }

    @PostMapping
    public Cliente guardar(@RequestBody Cliente c){
        return clienteRepo.save(c);
    }

    @GetMapping("/{id}")
    public Cliente obtenerLectura(@PathVariable Long id) {
        return clienteRepo.findById(id).orElse(null);
    }

    @GetMapping("/{clienteId}/Lecturas/{lecturaId}")
    public Cliente asociarLectura(@PathVariable Long clienteId, @PathVariable Long lecturaId) {
        Cliente cliente = clienteRepo.findById(clienteId).orElseThrow();
        Lecturas lectura = lecturaRepo.findById(lecturaId).orElseThrow();
        cliente.getLecturas().add(lectura);
        return clienteRepo.save(cliente);
    }




}
