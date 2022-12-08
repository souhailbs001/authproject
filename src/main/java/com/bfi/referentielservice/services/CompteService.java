package com.bfi.referentielservice.services;

import com.bfi.referentielservice.entities.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CompteService {
    //Compte saveCompte(Long personnePhysiqueId,double initialBalance );
    Compte saveCompte(Compte compte);
    List<Compte> listComptes();
    void deleteCompte (Compte compte);
    Compte updateCompte (Compte compte);
    String generateNumCpt ();
    Compte getCompte(Long id);
    List<Compte> searchComptes(String keyword);


    //void deleteCompteById





}
