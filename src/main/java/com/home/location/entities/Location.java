package com.home.location.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


//location , locataire et paiement
        //location 3and'ha un/+ paiement
        //paiement 3andou location barka
        //locataire 3andou 1/+ location
        //w location 3and'ha locataire barka
//location fiha dateDebut dateFin
@Entity

@Data

@NoArgsConstructor

@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    @Column(name = "dateDebut")
    private java.time.LocalDate dateDebut;
    @Column(name = "dateFin")
    private java.time.LocalDate dateFin;

    //relation with the locataire: un locataire peu avoir plusieurs locations
    @ManyToOne
    @JoinColumn(name = "LOCATAIRE_ID")  //optional: hibernate will generate one: references the mapped column
    private Locataire locataire;


    @OneToMany(mappedBy = "location")
    private Set<Paiement> paiementSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getId().equals(location.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
