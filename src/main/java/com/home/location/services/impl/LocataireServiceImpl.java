package com.home.location.services.impl;

import com.home.location.entities.Locataire;
import com.home.location.exceptions.LocataireNotFoundException;
import com.home.location.repositories.LocataireRepository;
import com.home.location.services.ILocataireService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocataireServiceImpl implements ILocataireService {

    private LocataireRepository repository;

    @Override
    public Locataire save(Locataire locataire) {
        return repository.save(locataire);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public List<Locataire> getAll() {
        return (List<Locataire>)repository.findAll();
    }

    @Override
    public Locataire getOneById(Long id) throws LocataireNotFoundException {
        return repository.findById(id).orElseThrow(LocataireNotFoundException::new);
    }
}
