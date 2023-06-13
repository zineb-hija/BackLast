package com.example.m6.ws;

import com.example.m6.bean.Prestation;
import com.example.m6.service.facade.PrestationService;
import com.example.m6.service.facade.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prestation")
public class PrestationWs {
    @Autowired
    private PrestationService prestationService;
@GetMapping("/hopital/{hopital}")
    public Prestation findByHopital(@PathVariable String hopital) {
        return prestationService.findByHopital(hopital);

    }
@Transactional
@DeleteMapping("/hopital/{hopital}")
    public int deleteByHopital(@PathVariable String hopital) {
        return prestationService.deleteByHopital(hopital);
    }
    @PostMapping("/")

    public Prestation save(@RequestBody Prestation prestation) {
        return prestationService.save(prestation);
    }
@GetMapping("/service/{service}")
    public Prestation findByService(@PathVariable String service) {
        return prestationService.findByService(service);
    }
@Transactional
@DeleteMapping("/service/{service}")
    public int deleteByService(@PathVariable String service) {
        return prestationService.deleteByService(service);
    }

    public List<Prestation> findAll() {
        return prestationService.findAll();
    }
}
