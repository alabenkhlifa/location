package com.home.location.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Locataire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "cin", length = 8)
    private String cin;
    @Column(name = "fullName")
    private String fullName;
    // Persisting Collections of basic Java types: equivalent to an entity with on-to-may association
    //dwarbacks: not the most efficient option to store a list of value types in the database
    //!!!!!only use it for very small collections !!!!!!!!
    @ElementCollection
    private List<String> numTel = new ArrayList<>();

    // relation with the location
// it is one to many mapping with foreign key association
    //Locataire should declare that relationship is one to many,
    // and Location should declare that relationship from its end is many to one.

    //“cascade=CascadeType.ALL” :any change happened on Locataire must cascade to Location as well
    //The mappedBy property is what we use to tell Hibernate
    // which variable we are using to represent the Locataire class in the location class.
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locataire")
//    private Set<Location> locationSet = new HashSet<>();

    public Locataire(String cin, String fullName, List<String> numTel) {
        this.cin = cin;
        this.fullName = fullName;
        this.numTel = numTel;
    }

    public Locataire() {
    }

//    public Set<Location> getLocationSet() {
//        return locationSet;
//    }

//    public void setLocationSet(Set<Location> locationSet) {
//        this.locationSet = locationSet;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<String> getNumTel() {
        return numTel;
    }

    public void setNumTel(List<String> numTel) {
        this.numTel = numTel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Locataire)) return false;
        Locataire locataire = (Locataire) o;
        return id.equals(locataire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Locataire{" +
                "id=" + id +
                ", cin=" + cin +
                ", fullName='" + fullName + '\'' +
                ", numTel=" + numTel +
                '}';
    }
}
