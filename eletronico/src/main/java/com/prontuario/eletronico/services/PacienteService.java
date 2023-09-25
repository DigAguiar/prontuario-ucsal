package com.prontuario.eletronico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.prontuario.eletronico.DTOs.CadastroDadosPessoaisDTO;
import com.prontuario.eletronico.entities.Log;
import com.prontuario.eletronico.entities.Pacient;
import com.prontuario.eletronico.entities.UserModel;
import com.prontuario.eletronico.repositories.LogRepository;
import com.prontuario.eletronico.repositories.PacienteRepository;
import com.prontuario.eletronico.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PacienteService {
    
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Pacient> findAll(){
        var lista = pacienteRepository.findAll();
        return lista;
    }

    public void cadastrarDadosPessoais(CadastroDadosPessoaisDTO request){
        var paciente = new Pacient();
        var log = new Log();
        var user = new UserModel();

        paciente.setNome("Neymar");
        paciente = pacienteRepository.save(paciente);

        // userLogged?
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        user = userRepository.findByEmail(username).get();

        log.setIdUser(user.getId());
        log.setIdPaciente(paciente.getId());
        log.setAction("criar dados pessoais");
        logRepository.save(log);
    }

}
