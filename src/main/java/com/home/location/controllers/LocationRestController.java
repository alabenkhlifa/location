package com.home.location.controllers;

import com.home.location.entities.Location;
import com.home.location.exceptions.LocationNotFoundException;
import com.home.location.services.ILocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
@CrossOrigin("*")
public class LocationRestController {

    private ILocationService locationService;

    public LocationRestController(ILocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/")
    public List<Location> getAll() {
        return locationService.getAll();
    }

    @GetMapping("/{id}")
    public Location getOneByID(@PathVariable Long id) throws LocationNotFoundException {
        return locationService.getOneById(id);
    }

    @DeleteMapping("/")
    public ResponseEntity deleteAll() {
        locationService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        locationService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/")
    public ResponseEntity save(@RequestBody Location location) {
        location = locationService.save(location);
        return ResponseEntity.status(HttpStatus.CREATED).body(location);
    }

    @PutMapping("/")
    public ResponseEntity update(@RequestBody Location location) {
        location = locationService.save(location);
        return ResponseEntity.status(HttpStatus.OK).body(location);
    }

    @GetMapping("/locataire/{locataireID}")
    public List<Location> getByLocataireId(@PathVariable Long locataireID){
        return locationService.getByLocataireId(locataireID);
    }
}
