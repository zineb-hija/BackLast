package com.example.m6.dao;

import com.example.m6.bean.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementDao extends JpaRepository<Departement, Long> {
    Departement findByLibelle(String libelle);

    int deleteByLibelle(String libelle);

    boolean existsByLibelle(String libelle);
}
