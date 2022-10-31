package com.example.glsib.Entite;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(property = "id",generator =  ObjectIdGenerators.PropertyGenerator.class)

public class Customer extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "customer")
    private List<Comment> comment;
    @OneToMany(mappedBy = "customer")
    private List<Message> message;
}
