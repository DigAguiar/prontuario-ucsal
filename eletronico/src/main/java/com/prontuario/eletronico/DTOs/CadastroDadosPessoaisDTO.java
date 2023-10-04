package com.prontuario.eletronico.DTOs;

import java.time.LocalDate;
import java.time.LocalTime;

public record CadastroDadosPessoaisDTO(
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
    LocalTime hora) {


}