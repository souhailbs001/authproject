package com.bfi.referentielservice.services;


import com.bfi.referentielservice.entities.Banque;
import com.bfi.referentielservice.entities.Compte;
import com.bfi.referentielservice.repositories.BanqueRepository;
import com.bfi.referentielservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Random;

@Service
public class CompteServiceImpl implements CompteService {

    @Autowired
    CompteRepository compteRepository;


    @Override
    public Compte addCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    @Override
    public List<Compte> listComptes() {
        return compteRepository.findAll();
    }

    @Override
    public void deleteCompte(Compte compte) {
        compteRepository.delete(compte);
    }

    @Override
    public Compte updateCompte(Compte compte) {
        return compteRepository.save(compte);

    }

    @Override
    public String generateRib() {
        Random rand = new Random();
        String card = "BE";
        for (int i = 0; i < 14; i++)
        {
            int n = rand.nextInt(10) + 0;
            card += Integer.toString(n);
        }
        System.out.println(card);
        return card;
    }

    //public void deleteCompteById(Long id) {
    //    compteRepository.deleteCompteById(id);
    //}



}
