package com.example.m6;


import com.example.m6.service.impl.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class M6Application {


    public static void main(String[] args) {
        SpringApplication.run(M6Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() throws MessagingException {
        senderService.sendSimpleEmail("zineb09092001@gmail.com",
                "CHU",
                "Votre dossier est en cours du traitement pour confirmer votre demande veuillez cliquez sur ce lien " +
                        "www.confirmation.com");

    }

    @Autowired
    private EmailSenderService senderService;
}

