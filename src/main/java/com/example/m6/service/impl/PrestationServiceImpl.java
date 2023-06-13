package com.example.m6.service.impl;

import com.example.m6.bean.Prestation;
import com.example.m6.dao.PrestationDao;
import com.example.m6.service.facade.PrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestationServiceImpl implements PrestationService {
    @Autowired
    public PrestationDao prestationDao;

    @Override
    public int deleteByHopital(String hopital) {
        return prestationDao.deleteByHopital(hopital);
    }

    @Override
    public Prestation findByHopital(String hopital) {
        return prestationDao.findByHopital(hopital);
    }

    @Override
    public int deleteByService(String service) {
        return prestationDao.deleteByService(service);
    }

    @Override
    public Prestation findByService(String service) {
        return prestationDao.findByService(service);
    }

    @Override
    public List<Prestation> findAll() {
        return prestationDao.findAll();
    }

    @Override
    public Prestation save(Prestation prestation) {
        prestationDao.save(prestation);
        return prestation;
    }
}
