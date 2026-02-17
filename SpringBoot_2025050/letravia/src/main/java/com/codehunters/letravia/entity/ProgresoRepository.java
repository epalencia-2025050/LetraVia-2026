package com.codehunters.letravia;

import com.codehunters.letravia.entity.Progreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgresoRepository extends JpaRepository<Progreso, Long> {
}