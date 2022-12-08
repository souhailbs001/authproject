package com.bfi.referentielservice.services;

import com.bfi.referentielservice.entities.PersonnePhysique;
import com.bfi.referentielservice.entities.Tiers;
import com.bfi.referentielservice.repositories.PersonnePhysiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.List;
 @Service
public class PersonnePhysiqueServiceImplementation implements PersonnePhysiqueService{

    @Autowired
    PersonnePhysiqueRepository personnePhysiqueRepository;

    @Override
    public PersonnePhysique addPersonnePhysique(PersonnePhysique pp) {
        pp.setNomComplet(pp.getNom()
                        .concat(" ")
                        .concat(pp.getPrenom()));
        pp.setDateDeCreation(LocalDate.now());
        //pp.setAge(Year.now().minusYears(pp.getDateDeNaissance().getYear()));
        //pp.setAge(ChronoUnit.YEARS.between(pp.getDateDeNaissance(), LocalDate.now()));
        return personnePhysiqueRepository.save(pp);
    }




    @Override
    public List<PersonnePhysique> listPersonnePhysique() {

        return personnePhysiqueRepository.findAll();
    }

    @Override
    public void deletePersonnePhysique(PersonnePhysique pp) {
        personnePhysiqueRepository.delete(pp);

    }


}
