package com.home.location.controllers;

import com.home.location.entities.Paiement;
import com.home.location.exceptions.PaiementNotFoundException;
import com.home.location.services.IPaiementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paiement")
public class PaiementRestController {

    private IPaiementService paiementService;

    public PaiementRestController(IPaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @GetMapping("/")
    public List<Paiement> getAll() {
        return paiementService.getAll();
    }

    @GetMapping("/{id}")
    public Paiement getOneByID(@PathVariable Long id) throws PaiementNotFoundException {
        return paiementService.getOneById(id);
    }

    @DeleteMapping("/")
    public ResponseEntity deleteAll() {
        paiementService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/")
    public ResponseEntity save(@RequestBody Paiement paiement) {
        paiement = paiementService.save(paiement);
        return ResponseEntity.status(HttpStatus.CREATED).body(paiement);
    }

    @PutMapping("/")
    public ResponseEntity update(@RequestBody Paiement paiement) {
        paiement = paiementService.save(paiement);
        return ResponseEntity.status(HttpStatus.OK).body(paiement);
    }
}
