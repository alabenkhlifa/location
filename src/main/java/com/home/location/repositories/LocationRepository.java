package com.home.location.repositories;

import com.home.location.entities.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LocationRepository extends CrudRepository<Location,Long> {
    List<Location> findByLocataire_Id(Long locataireId);
}
