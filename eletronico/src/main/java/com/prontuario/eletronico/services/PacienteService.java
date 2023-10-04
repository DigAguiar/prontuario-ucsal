package com.prontuario.eletronico.services;

import java.util.Date;
import java.util.List;

import com.prontuario.eletronico.DTOs.CadastroDadosFichaTecnicaDTO;
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

    public Pacient findPacientBy (int id) {
        return pacienteRepository.getReferenceById(id);
    }


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
        paciente.setContatos(request.contato());
        paciente.setCurso(request.curso());
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
    public void cadastrarDadosFichaTecnica (CadastroDadosFichaTecnicaDTO request, Pacient paciente) {
        var log = new Log();
        var user = new UserModel();
        var dataAtual = new Date(); // Obtém a data atual

        paciente.setAltura(request.altura());
        paciente.setAlergias(request.alergia());
        paciente.setPressao_arterial(request.pressao_arterial());
        paciente.setTemperatura(request.temperatura());
        paciente.setDor(request.dor());
        paciente.setSaturacao(request.saturacao());
        paciente.setGlicemia_capilar(request.glicemia_capilar());
        paciente.setComorbidades(request.comorbidades());

        pacienteRepository.save(paciente);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        user = userRepository.findByEmail(username).get();

        log.setIdUser(user.getId());
        log.setIdPaciente(paciente.getId());
        log.setAction("criar dados pessoais");
        logRepository.save(log);
    }


    public void cadastrarPaciente(Pacient request) {
        var paciente = new Pacient();
        var log = new Log();
        var user = new UserModel();
        var dataAtual = new Date(); // Obtém a data atual

        paciente = pacienteRepository.save(request);

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

    public void deleteById(Integer id) {
        pacienteRepository.deleteById(id);
    }

    public Pacient findById(Integer id) {
        return pacienteRepository.findById(id).get();
    }
}