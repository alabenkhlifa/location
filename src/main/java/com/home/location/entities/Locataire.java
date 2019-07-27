package com.home.location.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Locataire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long id;
    @Column(name = "cin")
    private Long cin;
    @Column(name = "fullName")
    private String fullName;
    // Persisting Collections of basic Java types: equivalent to an entity with on-to-may association
    //dwarbacks: not the most efficient option to store a list of value types in the database
    //!!!!!only use it for very small collections !!!!!!!!
    @ElementCollection
    private List<Long> numTel= new ArrayList<>();

    // relation with the location
// it is one to many mapping with foreign key association
    //Locataire should declare that relationship is one to many,
    // and Location should declare that relationship from its end is many to one.

    //“cascade=CascadeType.ALL” :any change happened on Locataire must cascade to Location as well
    //The mappedBy property is what we use to tell Hibernate
    // which variable we are using to represent the Locataire class in the location class.
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "locataire")
    private Set<Location> locationSet= new HashSet<>();

    public Locataire(Long cin, String fullName, List<Long> numTel) {
        this.cin = cin;
        this.fullName = fullName;
        this.numTel = numTel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCin() {
        return cin;
    }

    public void setCin(Long cin) {
        this.cin = cin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Long> getNumTel() {
        return numTel;
    }

    public void setNumTel(List<Long> numTel) {
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
