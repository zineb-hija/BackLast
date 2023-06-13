package com.example.m6.service.facade;

import com.example.m6.bean.StatutNotification;

import java.util.List;

public interface StatutNotificationService {
    StatutNotification findByCode(String code);

    int deleteByCode(String code);

    StatutNotification save(StatutNotification statutNotification);
    List<StatutNotification> findAll();
}
