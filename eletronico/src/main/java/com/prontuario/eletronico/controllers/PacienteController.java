package com.prontuario.eletronico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prontuario.eletronico.DTOs.CadastroDadosPessoaisDTO;
import com.prontuario.eletronico.services.PacienteService;

@Controller
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/")
    public String listarPacientes(Model model) {
        var listaPacientes = pacienteService.findAll();
        model.addAttribute("pacientes", listaPacientes);
        return "index";
    }

    @GetMapping("/cadastarDados")
    public String cadastarDadosPessoais() {
        return "paciente/cadastroDados";
    }

    @PostMapping("/cadastarDados")
    public String cadastarDadosPessoaisPOST(@ModelAttribute CadastroDadosPessoaisDTO request) {
        pacienteService.cadastrarDadosPessoais(request);
        return "redirect:/";
    }

    @GetMapping("/cadastarFichaTecnica")
    public String cadastarFichaTecnica() {
        return "paciente/cadastroFicha";
    }

    @PostMapping("/cadastarFichaTecnica")
    public String cadastarFichaTecnicaPOST(@ModelAttribute CadastroDadosPessoaisDTO request) {
        pacienteService.cadastrarDadosPessoais(request);
        return "paciente/cadastroFicha";
    }

    // Construir controllers para receber o site com o ID na url, e então salvar o restante as info
//    @GetMapping("cadastroFicha={id}")
//    public String preencherFichaTecnica (@PathVariable int id) {
//       var p = pacienteService.findPacientBy(id);
//       pacienteService.cadastrarDadosFichaTecnica(p);
//    }


}
