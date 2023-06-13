package com.example.m6.ws;

import com.example.m6.bean.Service;
import com.example.m6.service.facade.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
public class ServiceWs {
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/libelle/{libelle}")
    public Service findByLibelle(@PathVariable String libelle) {
        return serviceService.findByLibelle(libelle);
    }

    @Transactional
    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return serviceService.deleteByLibelle(libelle);
    }

    @PostMapping("/")
    public Service save(@RequestBody Service service) {
        return serviceService.save(service);
    }

    public List<Service> findAll() {
        return serviceService.findAll();
    }
}
