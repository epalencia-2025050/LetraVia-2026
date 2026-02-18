package com.codehunters.letravia.Repository;

import com.codehunters.letravia.Entity.Ejercicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjerciciosRepository extends JpaRepository<Ejercicios, Integer> {

}
