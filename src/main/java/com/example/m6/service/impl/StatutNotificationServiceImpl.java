package com.example.m6.service.impl;

import com.example.m6.bean.StatutNotification;
import com.example.m6.dao.StatutNotificationDao;
import com.example.m6.service.facade.StatutNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatutNotificationServiceImpl implements StatutNotificationService {
    @Autowired
    private StatutNotificationDao statutNotificationDao;

    @Override
    public StatutNotification findByCode(String code) {
        return null;
    }

    @Override
    public int deleteByCode(String code) {
        return 0;
    }

    @Override
    public List<StatutNotification> findAll() {
        return statutNotificationDao.findAll();
    }

    public StatutNotification save(StatutNotification statutNotification) {
        StatutNotification stn = null;

        if (findByCode(statutNotification.getCode()) == null) {
            stn = statutNotificationDao.save(statutNotification);

        }
        return stn;

    }
}
