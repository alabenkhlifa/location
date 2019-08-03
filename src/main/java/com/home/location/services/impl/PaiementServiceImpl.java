package com.home.location.services.impl;

import com.home.location.entities.Paiement;
import com.home.location.exceptions.PaiementNotFoundException;
import com.home.location.repositories.PaiementRepository;
import com.home.location.services.IPaiementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private PaiementRepository repository;

    @Override
    public Paiement save(Paiement paiement) {
        return repository.save(paiement);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public List<Paiement> getAll() {
        return (List<Paiement>) repository.findAll();
    }

    @Override
    public Paiement getOneById(Long id) throws PaiementNotFoundException {
        return repository.findById(id).orElseThrow(PaiementNotFoundException::new);
    }
}
