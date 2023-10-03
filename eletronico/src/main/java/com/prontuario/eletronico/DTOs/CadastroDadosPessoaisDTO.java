package com.prontuario.eletronico.DTOs;

import com.prontuario.eletronico.entities.Pacient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public record CadastroDadosPessoaisDTO<alergia>
        (
                String name,
                String email,
                String contato,
                String curso,
                LocalDate data_nascimento,
                String colaborador,
                String externo,
                String cep,
                String endereco,
                String cidade,
                String bairro,
                int numero,
                LocalDate data,
                LocalTime hora,
                String alergia,
                String exames_fisicos,
                String altura,
                String frequencia_respiratoria,
                String pressao_arterial,
                String frequencia_cardiaca,
                String temperatura,
                String saturacao,
                String dor,
                String glicemia_capilar,
                String comorbidades
                ) {

}