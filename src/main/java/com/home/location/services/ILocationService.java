package com.home.location.services;

import com.home.location.entities.Location;
import com.home.location.exceptions.LocationNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILocationService {
    Location save(Location location);
    void deleteAll();
    List<Location> getAll();
    Location getOneById (Long id) throws LocationNotFoundException;
    List<Location> getByLocataireId(Long locataireId);
}
