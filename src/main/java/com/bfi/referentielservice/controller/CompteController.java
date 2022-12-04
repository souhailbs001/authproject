package com.bfi.referentielservice.controller;
import com.bfi.referentielservice.entities.Compte;
import com.bfi.referentielservice.entities.PersonnePhysique;
import com.bfi.referentielservice.entities.Tiers;
import com.bfi.referentielservice.repositories.CompteRepository;
import com.bfi.referentielservice.repositories.TiersRepository;
import com.bfi.referentielservice.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CompteController {


    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private CompteService compteService;


    /*public CompteController(CompteRepository compteRepository, CompteService compteService){
        this.compteRepository = compteRepository;
        this.compteService = compteService;

    }*/

    @CrossOrigin
    @RequestMapping(value = "/saveCompte", method = RequestMethod.POST)
        public Compte saveAccount(@RequestBody Long personnePhysiqueId,@RequestBody double initialBalance){
            return compteService.saveCompte(personnePhysiqueId,initialBalance);
    }

    @CrossOrigin
    @RequestMapping(value = "/listCompte", method = RequestMethod.GET)
    public List<Compte> listComptes(){
        return compteService.listComptes();
    }

    @GetMapping ("/getCompteClient/{id}")
    public Compte getCompteClient(@PathVariable  Long id){
        return compteService.getCompte(id);
    }

    @DeleteMapping("/deleteCompte")
    public void deleteCompte(@PathVariable("id") Long id ){
    }

    @DeleteMapping("/deleteCompteById/{id}")
    public void deleteCompteById(@PathVariable("id") Long id){
        compteRepository.deleteById(id);

    }
    @GetMapping ("/generateNumCpt")
    public String generateNumCpt() {
        return compteService.generateNumCpt();
    }

}
