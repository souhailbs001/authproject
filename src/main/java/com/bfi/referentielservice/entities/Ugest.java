package com.bfi.referentielservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ugest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String codeInterne;
    private String libcou;
    private String liblon;
    @OneToMany (mappedBy = "ugest")
    private Collection<PersonnePhysique> personnePhysique;
    @OneToMany(mappedBy = "ugest")
    private Collection<Compte> comptes;

    //@ManyToOne
    //private Ugest agenceParent;


}
