package com.bfi.referentielservice.repositories;

import com.bfi.referentielservice.entities.PersonnePhysique;
import com.bfi.referentielservice.entities.Tiers;
import com.google.common.util.concurrent.ListeningExecutorService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonnePhysiqueRepository extends JpaRepository <PersonnePhysique,Long> {
    PersonnePhysique findByNom(String nom);
    List<PersonnePhysique> findByNomContains(String nom);
    List<PersonnePhysique> findByNomPereContains(String nomPere);



}
