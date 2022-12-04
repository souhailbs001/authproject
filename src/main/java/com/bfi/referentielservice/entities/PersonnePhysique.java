package com.bfi.referentielservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
//@DiscriminatorValue("PP")
public class PersonnePhysique implements Serializable {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long personnePhysiqueid;
    private String nom;
    private String Prenom;
    private String sexe;
    private Date dateDeNaissance;
    private Date dateDeCreation;
    private int age;
    private String etatCivil;
    private String nomPere;
    private String nomMere;
    private String PaysNaissance;
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
