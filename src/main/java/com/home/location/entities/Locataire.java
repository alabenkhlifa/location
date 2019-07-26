package com.home.location.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Locataire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", updatable = false, nullable=false)
    private Long id;
    @Column(name = "cin")
    private Long cin;
    @Column(name = "fullName")
    private String fullName;
    // Persisting Collections of basic Java types: equivalent to an entity with on-to-may association
    //dwarbacks: not the most efficient option to store a list of value types in the database
    //!!!!!only use it for very small collections !!!!!!!!
    @ElementCollection
    private List<Long> numTel;

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
