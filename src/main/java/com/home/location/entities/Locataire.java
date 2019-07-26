package com.home.location.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
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



}
