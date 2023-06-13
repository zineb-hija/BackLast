package com.example.m6.ws;

import com.example.m6.bean.TypeRemplissage;
import com.example.m6.service.facade.TypeRemplissageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/typeRemplissage")
public class TypeRemplissageWs {
    @Autowired
    private TypeRemplissageService typeRemplissageService;

    @GetMapping("/id/{id}")

    public TypeRemplissage findById(@PathVariable Long id) {
        return typeRemplissageService.findById(id);
    }

    @Transactional
    @DeleteMapping("/id/{id}")

    public int deleteById(@PathVariable Long id) {
        return typeRemplissageService.deleteById(id);
    }

    @PostMapping("/")

    public TypeRemplissage save(@RequestBody TypeRemplissage typeRemplissage) {
        return typeRemplissageService.save(typeRemplissage);
    }

    public List<TypeRemplissage> findAll() {
        return typeRemplissageService.findAll();
    }
}
