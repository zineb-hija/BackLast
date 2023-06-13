package com.example.m6.service.impl;

import com.example.m6.dao.ServiceDao;
import com.example.m6.service.facade.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceDao serviceDao;


    @Override
    public com.example.m6.bean.Service findByLibelle(String libelle) {
        return serviceDao.findByLibelle(libelle);
    }

    @Override
    public int deleteByLibelle(String libelle) {
        return serviceDao.deleteByLibelle(libelle);
    }

    @Override
    public List<com.example.m6.bean.Service> findAll() {
        return serviceDao.findAll();
    }

    @Override
    public com.example.m6.bean.Service save(com.example.m6.bean.Service service) {
        serviceDao.save(service);
        return service;
    }

}
