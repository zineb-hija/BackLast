package com.example.m6.service.impl;

import com.example.m6.bean.Notification;
import com.example.m6.dao.NotificationDao;
import com.example.m6.service.facade.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationDao notificationDao;


    @Override
    public Notification findById(Long id) {
        return null;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public List<Notification> findAll() {
        return notificationDao.findAll();
    }

    public Notification save(Notification notification) {
        Notification not = null;

        if (findById(notification.getId()) == null) {
            not = notificationDao.save(notification);
        }
        return not;

    }
}
