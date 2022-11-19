package com.bfi.referentielservice.services;


import com.bfi.referentielservice.entities.*;
import com.bfi.referentielservice.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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


    @Override
    //public Compte saveCompte( String nom) {

        public Compte saveCompte( PersonnePhysique p) {


       // PersonnePhysique client =personnePhysiqueRepository.findByNom(nom);
        PersonnePhysique client =personnePhysiqueRepository.findById(p.getId()).get();
        System.out.println(client);
        Compte compte = new Compte();
        compte.setNumCpt(generateNumCpt());
        compte.setDateCreation(new Date());
        compte.setTiers(client);
        Compte savedAccount  = compteRepository.save(compte);
        return savedAccount;
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

    //public void deleteCompteById(Long id) {
    //    compteRepository.deleteCompteById(id);
    //}



}
