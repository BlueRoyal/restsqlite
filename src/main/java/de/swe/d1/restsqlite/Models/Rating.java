package de.swe.d1.restsqlite.Models;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rating_id;

    @NotNull
    @Column(nullable = false)
    private String text;

    @NotNull
    @Column(nullable = false)
    private double rating;

    //Getränke
    @ManyToOne
    private List<Beverage> beverage;

    //Getränke
    @ManyToOne
    private List<Business> business;


}
