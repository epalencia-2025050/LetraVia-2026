package com.codehunters.letravia.service;
import com.codehunters.letravia.Entity.Lecturas;
import com.codehunters.letravia.Repository.LecturasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LecturasService {

    private LecturasRepository lecturasRepository;

    public LecturasService(LecturasRepository lecturasRepository) {
        this.lecturasRepository = lecturasRepository;
    }

    public Lecturas crearLectura(Lecturas lectura) {
        return lecturasRepository.save(lectura);
    }

    public List<Lecturas> obtenerTodas() {
        return lecturasRepository.findAll();
    }

    public Lecturas obtenerPorId(Long id) {
        return lecturasRepository.findById(id) .orElseThrow();
    }

    public Lecturas actualizarLectura(Long id, Lecturas lecturaActualizada) {
        Lecturas lectura = obtenerPorId(id); lectura.setTituloLectura(lecturaActualizada.getTituloLectura());
        lectura.setNivelLectura(lecturaActualizada.getNivelLectura());
        lectura.setDocumento(lecturaActualizada.getDocumento());
        return lecturasRepository.save(lectura);
    }

    public void eliminarLectura(Long id) {
        lecturasRepository.deleteById(id);
    }
}
