package com.prontuario.eletronico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prontuario.eletronico.entities.Pacient;

public interface PacienteRepository extends JpaRepository<Pacient, Integer>{
    
}
