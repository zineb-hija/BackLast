package com.example.m6.service.facade;


import com.example.m6.bean.Notification;

import java.util.List;

public interface NotificationService {
    Notification findById(Long id);

    int deleteById(Long id);

    Notification save(Notification notification);
    List<Notification> findAll();
}
