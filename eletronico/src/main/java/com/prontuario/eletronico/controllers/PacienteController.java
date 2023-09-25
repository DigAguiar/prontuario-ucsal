package com.prontuario.eletronico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.prontuario.eletronico.DTOs.CadastroDadosPessoaisDTO;
import com.prontuario.eletronico.services.PacienteService;

@Controller
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/cadastarDados")
    public String cadastarDadosPessoais() {
        return "paciente/cadastroDados";
    }

    @PostMapping("/cadastarDados")
    public String cadastarDadosPessoaisPOST(@ModelAttribute CadastroDadosPessoaisDTO request) {

        pacienteService.cadastrarDadosPessoais(request);

        return "paciente/cadastroDados";
    }
}
