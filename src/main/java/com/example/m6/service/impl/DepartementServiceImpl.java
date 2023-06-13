package com.example.m6.service.impl;

import com.example.m6.bean.Departement;
import com.example.m6.dao.DepartementDao;
import com.example.m6.service.facade.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DepartementServiceImpl implements DepartementService {
    @Autowired
    private DepartementDao departementDao;

    @Override
    public Departement findByLibelle(String libelle) {
        return null;
    }

    @Override
    public int deleteByLibelle(String libelle) {
        return 0;
    }

    @Override

    public List<Departement> findAll() {
        return departementDao.findAll();
    }

    public Departement save(Departement departement) {
        Departement dep = null;

        if (findByLibelle(departement.getLibelle()) == null) {
            dep = departementDao.save(departement);
        }
        return dep;

    }
}
