package com.home.location.repositories;

import com.home.location.entities.Paiement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaiementRepository extends CrudRepository<Paiement,Long> {
    List<Paiement> findByLocation_Id(Long locationId);
}
