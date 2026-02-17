package com.eduardoemilio.KinalApp.repository;

import com.eduardoemilio.KinalApp.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,String> {
}

