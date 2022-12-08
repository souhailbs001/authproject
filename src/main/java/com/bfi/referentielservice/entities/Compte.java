package com.bfi.referentielservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Compte implements Serializable {
    @Id
    private String id;
    private String numCpt;
    private String description;
    private String rib;
    private double soldeComptable;
    private double soldeDisponible;
    private boolean cloture;
    private LocalDate dateCreation;
    private double initialBalance;
    private String devise;
    //private Date dateCloture;

    @ManyToOne
    private Banque banque;
    @ManyToOne
    private PersonnePhysique personnePhysique;
    @ManyToOne
    Currency currency;
    @ManyToOne
    private Ugest ugest;
    //@OneToMany(mappedBy = "compte")
    //private Collection<Currency> currencies;

}
