package com.codehunters.letravia.Repository;

import com.codehunters.letravia.Entity.Lecturas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturasRepository extends JpaRepository<Lecturas,Long> {

}
