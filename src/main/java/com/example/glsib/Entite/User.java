package com.example.glsib.Entite;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Data
public abstract class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String adresse;
    private int number;
    private Boolean blocked;
    private boolean valid;

}
