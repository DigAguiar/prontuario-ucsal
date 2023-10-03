package com.prontuario.eletronico.services;

import java.util.Date;
import java.text.SimpleDateFormat;
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

    @Autowired
    private EmailService emailService;

    public List<Pacient> findAll() {
        var lista = pacienteRepository.findAll();
        return lista;
    }

    public void cadastrarDadosPessoais(CadastroDadosPessoaisDTO request) {
        var paciente = new Pacient();
        var log = new Log();
        var user = new UserModel();
        var dataAtual = new Date(); // Obtém a data atual

        paciente.setNome(request.name());
        paciente.setEmail(request.email());
        paciente.setContatos(request.telefone());
        paciente.setData_nascimento(request.data_nascimento());
        paciente.setColaborador(request.colaborador());
        paciente.setExterno(request.externo());
        paciente.setCep(request.cep());
        paciente.setEndereco(request.endereco());
        paciente.setCidade(request.cidade());
        paciente.setBairro(request.bairro());
        paciente.setNumero(request.numero());
        paciente.setData_atendimento(request.data());
        paciente.setHorario_atendimento(request.hora());
        paciente = pacienteRepository.save(paciente);

        // send email
        emailService.sendEmail(paciente);

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
