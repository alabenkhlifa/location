package com.home.location.services;

import com.home.location.entities.Location;
import com.home.location.exceptions.LocationNotFoundException;

import java.util.List;

public interface ILocationService {
    Location save(Location location);
    void deleteAll();
    void deleteById(Long id);
    List<Location> getAll();
    Location getOneById (Long id) throws LocationNotFoundException;
    List<Location> getByLocataireId(Long locataireId);
}