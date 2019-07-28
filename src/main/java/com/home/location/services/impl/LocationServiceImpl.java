package com.home.location.services.impl;

import com.home.location.entities.Location;
import com.home.location.exceptions.LocationNotFoundException;
import com.home.location.repositories.LocationRepository;
import com.home.location.services.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

// TODO: Make 2 other services with their interfaces and exceptions and checking (like the 'montant' of the 'paiement' must be positive or else throw an exception
public class LocationServiceImpl implements ILocationService {

    private LocationRepository locationRepository;
    // Optional , we can remove it and it still works
    @Autowired
    public LocationServiceImpl(LocationRepository repository) {
        this.locationRepository = repository;
    }

    // TODO : Compare the dates , the end date must be after the begin date or else throw a custom exception that you have to create in the 'exception' package with the response code 412 and a message in your choice.
    @Override
    public Location save(Location location) {
        LocalDateTime dateDebut = location.getDateDebut();
        LocalDateTime dateFin = location.getDateFin();

        return locationRepository.save(location);
    }

    @Override
    public void deleteAll() {
        locationRepository.deleteAll();
    }

    @Override
    public List<Location> getAll() {
        return (List<Location>)locationRepository.findAll();
    }

    @Override
    public Location getOneById(Long id) throws LocationNotFoundException{
//        the locationRepository.findById returns an optional of location (Optional<Location>), which means a wrapper around the location, we can check if the object inside the optional
//        if it's null or the optional is empty , we can throw exception like we did here, we use the optional to remove the manual check if object != null
        return locationRepository.findById(id).orElseThrow(LocationNotFoundException::new);
    }
}
