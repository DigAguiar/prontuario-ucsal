package com.prontuario.eletronico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prontuario.eletronico.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
    Role findByName(String name);
}
