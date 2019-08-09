package com.home.location.services;

import com.home.location.entities.Locataire;
import com.home.location.exceptions.LocataireNotFoundException;

import java.util.List;

public interface ILocataireService {
    Locataire save(Locataire locataire);
    void deleteAll();
    List<Locataire> getAll();
    Locataire getOneById (Long id) throws LocataireNotFoundException;
}
