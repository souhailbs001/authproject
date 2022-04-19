package com.bfi.referentielservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Tiers")
public abstract class Tiers {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean ent;
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthday;
    private String libcou;
    private String liblon;
    @OneToMany (mappedBy = "tiers")
    private Collection<Compte> comptes;
    @ManyToOne
    private Country country;
    @OneToMany(mappedBy ="tiers" )
    private Collection<Ugest> ugests;
    @OneToMany(mappedBy = "tiers")
    private Collection<Contact>contacts;



}
