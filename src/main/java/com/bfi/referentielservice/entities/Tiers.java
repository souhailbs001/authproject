package com.bfi.referentielservice.entities;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="Tiers")
//@JsonDeserialize
public abstract class Tiers {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String Prenom;
    private String sexe;
    private Date dateDeNaissance;
    private Date dateDeCreation;
    /*@OneToMany (mappedBy = "pp")
    private Collection<Compte> comptes;*/
    @ManyToOne
    private Country country;
    /*@OneToMany(mappedBy ="ugest" )
    private Collection<Ugest> ugests;*/
    @OneToMany(mappedBy = "tiers")
    private Collection<Contact>contacts;



}
