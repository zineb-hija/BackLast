package com.example.m6.service.facade;

import com.example.m6.bean.Dossier;

import java.util.List;

public interface DossierService {
    Dossier findById(Long id);

    int deleteById(Long id);

    int save(Long id);
    List<Dossier> findAll();
}
