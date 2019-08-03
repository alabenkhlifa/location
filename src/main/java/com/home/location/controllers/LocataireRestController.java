package com.home.location.controllers;

import com.home.location.entities.Locataire;
import com.home.location.exceptions.LocataireNotFoundException;
import com.home.location.services.ILocataireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locataire")
public class LocataireRestController {

    private ILocataireService locataireService;

    public LocataireRestController(ILocataireService locataireService) {
        this.locataireService = locataireService;
    }

    @GetMapping("/")
    public List<Locataire> getAll() {
        return locataireService.getAll();
    }

    @GetMapping("/{id}")
    public Locataire getOneByID(@PathVariable Long id) throws LocataireNotFoundException {
        return locataireService.getOneById(id);
    }

    @DeleteMapping("/")
    public ResponseEntity deleteAll() {
        locataireService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/")
    public ResponseEntity save(@RequestBody Locataire locataire) {
        locataire = locataireService.save(locataire);
        return ResponseEntity.status(HttpStatus.CREATED).body(locataire);
    }

    @PutMapping("/")
    public ResponseEntity update(@RequestBody Locataire locataire) {
        locataire = locataireService.save(locataire);
        return ResponseEntity.status(HttpStatus.OK).body(locataire);
    }
}
