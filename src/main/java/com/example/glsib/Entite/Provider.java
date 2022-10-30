package com.example.glsib.Entite;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(property = "id",generator =  ObjectIdGenerators.PropertyGenerator.class)
public class Provider extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String diploma;
    private int avis;
    private String image;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Service service;
    private String description;

    @OneToMany(mappedBy = "provider")
    private List<Message> message;


}
