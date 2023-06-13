package com.example.m6.service.facade;

import com.example.m6.bean.Service;

import java.util.List;

public interface ServiceService {
    Service findByLibelle(String libelle);

    int deleteByLibelle(String libelle);

    Service save(Service service);
    List<Service> findAll();
}
