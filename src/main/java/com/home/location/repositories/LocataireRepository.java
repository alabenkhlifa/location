package com.home.location.repositories;

import com.home.location.entities.Locataire;
import org.springframework.data.repository.CrudRepository;

public interface LocataireRepository extends CrudRepository<Locataire,Long> {
}
