package com.prontuario.eletronico.entities;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLog;
    private Integer idPaciente;
    private Integer idUser;
    private String action;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime data;
 
    public Log() {
    }
    public Log(Integer idLog, Integer idPaciente, Integer idUser, String action, LocalDateTime data) {
        this.idLog = idLog;
        this.idPaciente = idPaciente;
        this.idUser = idUser;
        this.action = action;
        this.data = data;
    }
    public Integer getIdLog() {
        return idLog;
    }
    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }
    public Integer getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }
    public Integer getIdUser() {
        return idUser;
    }
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    } 
}