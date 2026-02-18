package com.codehunters.letravia.service;

import com.codehunters.letravia.Repository.AbecedarioRepository;
import org.springframework.stereotype.Service;
import com.codehunters.letravia.Entity.Abecedario;

import java.util.List;

@Service
public class AbecedarioService {

    private final AbecedarioRepository repository;

    public AbecedarioService(AbecedarioRepository repository){
        this.repository = repository;
    }

    //Metodo que lista las letras
    public List<Abecedario> listar(){
        return repository.findAll();

    }

    //Metodo que guarda
    public Abecedario guardar(Abecedario letra){
        return repository.save(letra);

    }


    //Metodo que busca las letras
    //Agrege el .orELse por si la busqueda no devuelve nada
    public Abecedario buscar(String letra){
        return repository.findById(letra).orElse(null);
    }

    //Metodo que elimina la letra
    public void eliminar(String letra){
        repository.deleteById(letra);

    }

    //Metodo que actualiza la letra
    //El .map() permite aplicar una función dada a cada elemento de una colección y devolver una nueva colección con los resultados.
    public Abecedario actualizar(String letra, Abecedario datosActualizados) {

        return repository.findById(letra)
                .map(registro -> {
                    registro.setLetraEjemplo(datosActualizados.getLetraEjemplo());
                    return repository.save(registro);
                }).orElseThrow(() -> new RuntimeException("Letra no encontrada"));
    }



}