package com.bfi.referentielservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Currency implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Long decimal;
    private String decimalName;
    private String name;
    private String translatedName;
    private Long quotity;
    private boolean certain;
    private String internalName;
    //@ManyToOne
    //private Compte compte;
    @OneToMany(mappedBy = "currency")
    private Collection<Compte> comptes;
    @ManyToOne
    private CrossParity crossParity;
    @ManyToOne
    private CurrencyPrice deviseAchat;
    @ManyToOne
    private CurrencyPrice deviseVente;



}
