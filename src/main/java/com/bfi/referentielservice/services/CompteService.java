package com.bfi.referentielservice.services;

import com.bfi.referentielservice.entities.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CompteService {
    Compte saveCompte(Long personnePhysiqueId,double initialBalance );
    List<Compte> listComptes();
    void deleteCompte (Compte compte);
    Compte updateCompte (Compte compte);
    String generateNumCpt ();
    Compte getCompte(Long id);


    //void deleteCompteById





}
