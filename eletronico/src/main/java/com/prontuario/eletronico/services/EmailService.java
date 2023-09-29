package com.prontuario.eletronico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.prontuario.eletronico.entities.Pacient;

@Service
public class EmailService {

    @Autowired
	JavaMailSender emailSender;

    public void sendEmail(Pacient paciente) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("diogoribeiro698@gmail.com");
        message.setTo(paciente.getEmail());
        message.setSubject("Agendamento Confirmado");
        message.setText(paciente.toString());
        emailSender.send(message);
    }
}
