package com.codehunters.letravia.Repository;

import com.codehunters.letravia.Entity.ProgresoEjercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProgresoEjercicioRepository extends JpaRepository<ProgresoEjercicio, Long> {
    List<ProgresoEjercicio> findByProgresoId(Long progresoId);
}