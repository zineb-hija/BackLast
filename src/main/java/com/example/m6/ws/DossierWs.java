package com.example.m6.ws;

import com.example.m6.bean.Dossier;
import com.example.m6.service.facade.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dossier")
public class DossierWs {
    @Autowired
    private DossierService dossierService;

    @GetMapping("/id/{id}")

    public Dossier findById(@PathVariable Long id) {
        return dossierService.findById(id);
    }

    @Transactional
    @DeleteMapping("/id/{id}")

    public int deleteById(@PathVariable Long id) {
        return dossierService.deleteById(id);
    }

    @PostMapping("/")

    public int save(@RequestBody Long id) {
        return dossierService.save(id);
    }

    public List<Dossier> findAll() {
        return dossierService.findAll();
    }
}
