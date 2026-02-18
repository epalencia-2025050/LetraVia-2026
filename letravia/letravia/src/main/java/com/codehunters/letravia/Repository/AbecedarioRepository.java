package com.codehunters.letravia.Repository;

import com.codehunters.letravia.Entity.Abecedario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbecedarioRepository extends JpaRepository<Abecedario,String> {
    String letra(String letra);

}