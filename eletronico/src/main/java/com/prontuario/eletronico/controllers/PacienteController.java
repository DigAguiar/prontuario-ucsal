package com.prontuario.eletronico.controllers;

import com.prontuario.eletronico.DTOs.CadastroDadosFichaTecnicaDTO;
import com.prontuario.eletronico.entities.Pacient;
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

    @GetMapping("/visualizarFicha/{id}")
    public String visualizarFicha (@PathVariable int id,Model model) {
        var paciente = pacienteService.findPacientBy(id);
        model.addAttribute("paciente",paciente);
        return "paciente/visualizarFicha";
    }


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


    @PostMapping("/cadastarFichaTecnica")
    public String cadastarFichaTecnicaPOST(@ModelAttribute CadastroDadosPessoaisDTO request) {
        pacienteService.cadastrarDadosPessoais(request);
        return "paciente/cadastroFicha";
    }

    @GetMapping("/delete/{id}")
    public String deletePaciente(@PathVariable("id") Integer id) {
        pacienteService.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updatePaciente(Pacient paciente) {
        pacienteService.cadastrarPaciente(paciente);
        return "redirect:/";
    }
    
    @GetMapping("/cadastarFichaTecnica/{id}")
    public String cadastarFichaTecnica(Model model, @PathVariable int id) {
        model.addAttribute("id",id);
        return "paciente/cadastroFicha";
    }

    @PostMapping("/cadastroFicha/{id}")
    public String preencherFichaTecnica (@PathVariable int id, @ModelAttribute CadastroDadosFichaTecnicaDTO request) {
       Pacient p = pacienteService.findPacientBy(id);
       pacienteService.cadastrarDadosFichaTecnica(request,p);
       return "redirect:/";
    }


}
