package com.prontuario.eletronico.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class Pacient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // ? Não sei com certeza se os seguintes atributos serão String ou Date
    // - data_nascimento:Date
    // - data_atendimento:String
    // - horario_atendimento:String

    private String nome;
    private String email;
    private LocalDate data_nascimento;
    private String curso;
    private String colaborador;
    private String externo;
    private String cep;
    private String endereco;
    private String cidade;
    private String bairro;
    int numero;
    private String contatos;
    private String altura;
    private LocalDate data_atendimento;
    private LocalTime horario_atendimento;
    private String alergias;
    private String pressao_arterial;
    private String temperatura;
    private String dor;
    private String saturacao;
    private String glicemia_capilar;
    private String comorbidades;
    private String medicacao_em_uso;
    private String evolucao_enfermagem;

    public Pacient(Integer id, String nome, String email, LocalDate data_nascimento, String curso, String colaborador, String externo,
                   String cep, String endereco, String cidade, String bairro, int numero,
                   String contatos, String altura, LocalDate data_atendimento, LocalTime horario_atendimento, String alergias,
                   String pressao_arterial, String temperatura, String dor, String saturacao, String glicemia_capilar, String comorbidades, String medicacao_em_uso,
                   String evolucao_enfermagem) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.curso = curso;
        this.colaborador = colaborador;
        this.externo = externo;
        this.cep = cep;
        this.endereco = endereco;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.contatos = contatos;
        this.altura = altura;
        this.data_atendimento = data_atendimento;
        this.horario_atendimento = horario_atendimento;
        this.alergias = alergias;
        this.pressao_arterial = pressao_arterial;
        this.temperatura = temperatura;
        this.dor = dor;
        this.saturacao = saturacao;
        this.glicemia_capilar = glicemia_capilar;
        this.comorbidades = comorbidades;
        this.medicacao_em_uso = medicacao_em_uso;
        this.evolucao_enfermagem = evolucao_enfermagem;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Pacient() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    public String getExterno() {
        return externo;
    }

    public void setExterno(String externo) {
        this.externo = externo;
    }

    public String getContatos() {
        return contatos;
    }

    public void setContatos(String contatos) {
        this.contatos = contatos;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getPressao_arterial() {
        return pressao_arterial;
    }

    public void setPressao_arterial(String pressao_arterial) {
        this.pressao_arterial = pressao_arterial;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getDor() {
        return dor;
    }

    public void setDor(String dor) {
        this.dor = dor;
    }

    public String getSaturacao() {
        return saturacao;
    }

    public void setSaturacao(String saturacao) {
        this.saturacao = saturacao;
    }

    public String getGlicemia_capilar() {
        return glicemia_capilar;
    }

    public void setGlicemia_capilar(String glicemia_capilar) {
        this.glicemia_capilar = glicemia_capilar;
    }

    public String getComorbidades() {
        return comorbidades;
    }

    public void setComorbidades(String comorbidades) {
        this.comorbidades = comorbidades;
    }

    public String getMedicacao_em_uso() {
        return medicacao_em_uso;
    }

    public void setMedicacao_em_uso(String medicacao_em_uso) {
        this.medicacao_em_uso = medicacao_em_uso;
    }

    public String getEvolucao_enfermagem() {
        return evolucao_enfermagem;
    }

    public void setEvolucao_enfermagem(String evolucao_enfermagem) {
        this.evolucao_enfermagem = evolucao_enfermagem;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public LocalDate getData_atendimento() {
        return data_atendimento;
    }

    public void setData_atendimento(LocalDate data_atendimento) {
        this.data_atendimento = data_atendimento;
    }

    public LocalTime getHorario_atendimento() {
        return horario_atendimento;
    }

    public void setHorario_atendimento(LocalTime horario_atendimento) {
        this.horario_atendimento = horario_atendimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
