package com.example.m6.service.facade;

import com.example.m6.bean.Departement;
import com.example.m6.bean.Prestation;

import java.util.List;

public interface PrestationService {
    Prestation findByHopital(String hopital);

    int deleteByHopital(String hopital);

    Prestation save(Prestation prestation);
    Prestation findByService(String service);

    int deleteByService(String service);
    List<Prestation> findAll();

}
