package com.example.m6.ws;

import com.example.m6.bean.Departement;
import com.example.m6.service.facade.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departement")
public class DepartementWs {
    @Autowired
    private DepartementService departementService;

    @GetMapping("/libelle/{libelle}")
    public Departement findByLibelle(@PathVariable String libelle) {
        return departementService.findByLibelle(libelle);
    }

    @Transactional
    @DeleteMapping("/libelle/{libelle}")

    public int deleteByLibelle(@PathVariable String libelle) {
        return departementService.deleteByLibelle(libelle);
    }

    @PostMapping("/")

    public Departement save(@RequestBody Departement departement) {
        return departementService.save(departement);
    }

    public List<Departement> findAll() {
        return departementService.findAll();
    }
}
