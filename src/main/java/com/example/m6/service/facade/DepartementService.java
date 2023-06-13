package com.example.m6.service.facade;


import com.example.m6.bean.Departement;

import java.util.List;

public interface DepartementService {
    Departement findByLibelle(String libelle);

    int deleteByLibelle(String libelle);

    Departement save(Departement departement);
    List<Departement> findAll();

}
