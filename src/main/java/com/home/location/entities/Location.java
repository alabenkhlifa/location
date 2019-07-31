package com.home.location.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    @Column(name = "dateDebut")
    private LocalDateTime dateDebut;
    @Column(name = "dateFin")
    private LocalDateTime dateFin;

    //relation with the locataire: un locataire peu avoir plusieurs locations
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "LOCATAIRE_ID")  //optional: hibernate will generate one: references the mapped column
    private Locataire locataire;

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
