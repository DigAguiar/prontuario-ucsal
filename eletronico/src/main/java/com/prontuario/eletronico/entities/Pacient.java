package com.prontuario.eletronico.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
    private Date data_nascimento;
    private String curso;
    private String colaborador;
    private String externo;
    private String contatos;
    private String altura;
    private Date data_atendimento;
    private String horario_atendimento;
    private String alergias;
    private String pressao_arterial;
    private String temperatura;
    private String dor;
    private String saturacao;
    private String glicemia_capilar;
    private String comorbidades;
    private String medicacao_em_uso;
    private String evolucao_enfermagem;

    

    public Pacient(Integer id, String nome, Date data_nascimento, String curso, String colaborador, String externo,
            String contatos, String altura, Date data_atendimento, String horario_atendimento, String alergias,
            String pressao_arterial, String temperatura, String dor, String saturacao, String glicemia_capilar,
            String comorbidades, String medicacao_em_uso, String evolucao_enfermagem) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.curso = curso;
        this.colaborador = colaborador;
        this.externo = externo;
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

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Date getData_atendimento() {
        return data_atendimento;
    }

    public void setData_atendimento(Date data_atendimento) {
        this.data_atendimento = data_atendimento;
    }

    public String getHorario_atendimento() {
        return horario_atendimento;
    }

    public void setHorario_atendimento(String horario_atendimento) {
        this.horario_atendimento = horario_atendimento;
    }
}
