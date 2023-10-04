package com.prontuario.eletronico.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.prontuario.eletronico.entities.Pacient;
import com.prontuario.eletronico.services.PacienteService;

@RestController
public class RestPacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/findPacienteById/{id}")
    public Pacient findPacienteById(@PathVariable Integer id) {
        var response = pacienteService.findById(id);
        return response;
    }
}
