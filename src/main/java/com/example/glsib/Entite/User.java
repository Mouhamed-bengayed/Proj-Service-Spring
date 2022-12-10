package com.example.glsib.Entite;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;




import javax.persistence.*;


import java.util.HashSet;
import java.util.Set;
@Data

@Entity
@Table(name = "User", uniqueConstraints = {
     @UniqueConstraint(columnNames = {"name"}),@UniqueConstraint(columnNames = {"email"})})

public  class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String prenom;
    private String email;
    private String password;
    private String adresse;
    private int number;
    private Boolean blocked;
    private Boolean isVerified;
    private String token;
    private String username;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private City city;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

  @ManyToOne
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

  private Service service;

    public User(String name, String username, String email, String password, boolean b) {
        this.name=name;
        this.username=username;
        this.email=email;
        this.password=password;
        this.isVerified=b;
    }

    public User() {

    }
}

