package com.bfi.referentielservice.services;

import com.bfi.referentielservice.entities.Ugest;
import com.bfi.referentielservice.repositories.UgestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UgestServiceImplementation implements UgestService {
    @Autowired
    UgestRepository ugestRepository;

    @Override
    public Ugest saveAgence(Ugest agence) {
        return ugestRepository.save(agence);
    }
}
