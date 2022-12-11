package com.bfi.referentielservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
//@DiscriminatorValue("PP")
public class PersonnePhysique implements Serializable {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String nomComplet;
    private String sexe;
    private LocalDate dateDeNaissance;
    private LocalDate dateDeCreation;
    private Long age ;
    private String etatCivil;
    private String nomPere;
    private String nomMere;
    private String paysNaissance;
    private String paysNationalite;
    private String paysResidence;
    private Long mobile;
    private String mail;
    @OneToMany (mappedBy = "personnePhysique")
    private Collection<Compte> comptes;
    @ManyToOne
    private Country country;
    @ManyToOne
    private Ugest ugest;

    /*@OneToMany(mappedBy = "tiers")
    private Collection<Contact>contacts;*/



}
