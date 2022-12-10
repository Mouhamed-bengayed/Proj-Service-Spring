package com.example.glsib.Entite;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany( fetch = FetchType.LAZY , cascade= CascadeType.ALL)
    @JsonIgnoreProperties
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<User> user;
}
