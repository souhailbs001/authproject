package com.bfi.referentielservice.services;


import com.bfi.referentielservice.entities.*;
import com.bfi.referentielservice.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
@AllArgsConstructor
public class CompteServiceImpl implements CompteService {

    @Autowired
    CompteRepository compteRepository;
    @Autowired
    PersonnePhysiqueRepository personnePhysiqueRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    TiersRepository tiersRepository;



    @Override
    public Compte updateCompte(Compte compte) {
        return compteRepository.save(compte);
    }


    //public Compte saveCompte( String nom) {
    @Override
    public Compte saveCompte( Compte compte) {

       // PersonnePhysique client =personnePhysiqueRepository.findByNom(nom);
        //PersonnePhysique client =personnePhysiqueRepository.findById(personnePhysiqueId).orElse(null);
        //if (client == null)
        //    throw new RuntimeException("Client introuvable");
        compte.setId(UUID.randomUUID().toString());
        compte.setNumCpt(generateNumCpt());
        compte.setDateCreation(LocalDate.now());
        compte.setDevise("XAF");
        //compte.setPersonnePhysique(client);
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
    public String generateNumCpt() {
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

    @Override
    public Compte getCompte(Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Compte> searchComptes(String keyword) {
        List<Compte> comptes=compteRepository.searchCompte(keyword);

        return comptes;
        // compteRepository.getByRib();
    }

    //public void deleteCompteById(Long id) {
    //    compteRepository.deleteCompteById(id);
    //}



}
