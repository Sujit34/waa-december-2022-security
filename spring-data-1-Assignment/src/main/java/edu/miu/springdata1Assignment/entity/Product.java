package edu.miu.springdata1Assignment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private double rating;

    @ManyToOne
    @JsonBackReference
    private Category category;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<Review> reviews;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
}
