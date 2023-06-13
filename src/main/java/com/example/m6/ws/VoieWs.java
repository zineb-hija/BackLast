package com.example.m6.ws;

import com.example.m6.bean.Voie;
import com.example.m6.service.facade.VoieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/voie")
public class VoieWs {
    @Autowired
    private VoieService voieService;

    @GetMapping("/id/{id}")

    public Voie findById(@PathVariable Long id) {
        return voieService.findById(id);
    }

    @Transactional
    @DeleteMapping("/id/{id}")

    public int deleteById(@PathVariable Long id) {
        return voieService.deleteById(id);
    }

    @PostMapping("/")

    public Voie save(@RequestBody Voie voie) {
        return voieService.save(voie);
    }

    public List<Voie> findAll() {
        return voieService.findAll();
    }
}
