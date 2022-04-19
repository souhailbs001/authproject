package com.bfi.referentielservice.controller;

import com.bfi.referentielservice.entities.PersonnePhysique;
import com.bfi.referentielservice.repositories.PersonnePhysiqueRepository;
import com.bfi.referentielservice.services.PersonnePhysiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonnePhysiqueController   {

    @Autowired
    PersonnePhysiqueService personnePhysiqueService;
    @Autowired
    PersonnePhysiqueRepository personnePhysiqueRepository;

    @GetMapping(value="/findByFirstNameContains/{name}")
    List<PersonnePhysique> rechercheTiers(@PathVariable(name = "firstName") String firstName){
        return personnePhysiqueRepository.findByFirstNameContains(firstName);
    }

    @RequestMapping(value="/findByNomPereContains/{nomPere}",method = RequestMethod.GET)
    List<PersonnePhysique> findByNomPere(@PathVariable(name="nomPere") String nomPere){
        return personnePhysiqueRepository.findByNomPereContains(nomPere);
    }

}
