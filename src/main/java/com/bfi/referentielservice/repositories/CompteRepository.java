package com.bfi.referentielservice.repositories;

import com.bfi.referentielservice.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface CompteRepository extends JpaRepository<Compte,Long> {
    void deleteCompteById(Long id);
    @Query("select c from Compte c where c.rib like :kw")
    List<Compte> searchCompte(@Param("kw") String keyword);
}
