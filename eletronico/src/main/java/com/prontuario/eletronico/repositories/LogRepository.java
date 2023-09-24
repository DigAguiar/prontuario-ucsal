package com.prontuario.eletronico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prontuario.eletronico.entities.Log;

public interface LogRepository extends JpaRepository<Log, Integer>{
    
}
