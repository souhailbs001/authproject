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

@CrossOrigin(origins = "http://localhost:4200")
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
    @RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
        public Compte saveAccount(@RequestBody Compte compte){
            return compteService.saveCompte(compte);
    }

    @CrossOrigin
    @RequestMapping(value = "/saveAccount2/{id}", method = RequestMethod.GET)
    public void saveAccount(@PathVariable("id") Long idCustomer){
        compteService.saveCompte2(idCustomer);
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
    public void deleteCompteById(@PathVariable("id") String id){
        compteRepository.deleteById(id);

    }
    @GetMapping ("/generateNumCpt")
    public String generateNumCpt() {
        return compteService.generateNumCpt();
    }

    /*@RequestMapping(value="/attacherCompteClient",method = RequestMethod.PUT)
    public Compte attacherCompteClient(@RequestBody PersonnePhysique pp){
        Compte compte1 = pp.getComptes();
        return compteService.saveCompte();
    }*/


    /*@GetMapping("/listCompte/search")
    public List<Compte> searchComptes(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return compteService.searchComptes("%"+keyword+"%");
    }*/

    /*@GetMapping("/listCompte/search")
    public List<Compte> searchComptes(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return compteService.searchComptes("%"+keyword+"%");
    }*/

    @GetMapping("/listCompte/getCompte/{rib}")
    public List<Compte> searchCompte(@PathVariable(name="rib") String rib ){
        return compteRepository.findByRibContains(rib);
    }

}
