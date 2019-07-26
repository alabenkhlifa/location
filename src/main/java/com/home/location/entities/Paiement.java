package com.home.location.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
// Generated Getters and Setters and toString Method
@Data
// Generates a default constructor (with no arguments)
@NoArgsConstructor
// Generates a constructor with all args
@AllArgsConstructor
public class Paiement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "paiementDate")
    // Date Type : to save the time along side with the date we use TIMESTAMP
    // TemporalType.DATE => this saves in the DB the date without any time: (2012-02-23 00:00:00)
    // TemporalType.TIME => this saves in the DB the time without any date: (10:00:00)
    // TemporalType.TIMESTAMP => this saves in the DB the time and the date: (2012-02-23 10:00:00)
   // @Temporal(TemporalType.TIMESTAMP)
    //since Java 8
    //The types from the java.time package are directly mapped to corresponding SQL types.
    // So there’s no need to explicitly specify @Temporal annotation
    private java.time.LocalDate datePaiement;
    // = 0L => default value for the attribute, PS : 0L the L stands for Long , because it's of type Long.
    private Long montant = 0L;


    @ManyToOne
    private Location location;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paiement)) return false;
        Paiement paiement = (Paiement) o;
        return getId().equals(paiement.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
