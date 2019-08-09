package com.home.location.services;

import com.home.location.entities.Locataire;
import com.home.location.entities.Paiement;
import com.home.location.exceptions.LocataireNotFoundException;
import com.home.location.exceptions.PaiementNotFoundException;

import java.util.List;

public interface IPaiementService {
    Paiement save(Paiement paiement);
    void deleteAll();
    List<Paiement> getAll();
    Paiement getOneById (Long id) throws PaiementNotFoundException;
}
