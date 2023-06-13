package com.example.m6.dao;

import com.example.m6.bean.TypeRemplissage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRemplissageDao extends JpaRepository<TypeRemplissage, Long> {
}
