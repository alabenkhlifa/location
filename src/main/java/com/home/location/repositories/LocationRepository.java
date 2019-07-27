package com.home.location.repositories;

import com.home.location.entities.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location,Long> {
    List<Location> findByLocataire_Id(Long locataireId);
}
