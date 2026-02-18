package com.codehunters.letravia.Controller;

import com.codehunters.letravia.Repository.ClienteRepository;
import com.codehunters.letravia.Repository.LecturasRepository;
import com.codehunters.letravia.Entity.Cliente;
import com.codehunters.letravia.Entity.Lecturas;
import com.codehunters.letravia.service.LecturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping({"/cliente", "/Menu/cliente"})
public class ClienteController {

    @Autowired
    private LecturasService lecturasService;

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

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Long id, @RequestBody Cliente clienteActualizado) {
        return clienteRepo.findById(id) .map(cliente -> { cliente.setNombre(clienteActualizado.getNombre());
            cliente.setApellido(clienteActualizado.getApellido());
            cliente.setEdad(clienteActualizado.getEdad());
            cliente.setUbicacion(clienteActualizado.getUbicacion());
            Cliente actualizado = clienteRepo.save(cliente);
            return ResponseEntity.ok(actualizado); }) .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}") public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (clienteRepo.existsById(id)) {
            clienteRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
        return ResponseEntity.notFound().build(); } }



}
