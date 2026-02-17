package com.codehunters.letravia;

import com.codehunters.letravia.entity.Lecturas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturasRepository extends JpaRepository<Lecturas,Long> {

}
