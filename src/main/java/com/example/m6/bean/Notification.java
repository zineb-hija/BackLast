package com.example.m6.bean;

import javax.persistence.*;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @ManyToOne
    private StatutNotification statutNotification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatutNotification getStatutNotification() {
        return statutNotification;
    }

    public void setStatutNotification(StatutNotification statutNotification) {
        this.statutNotification = statutNotification;
    }
}
