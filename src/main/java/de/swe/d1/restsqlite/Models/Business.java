package de.swe.d1.restsqlite.Models;

import com.sun.istack.NotNull;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;

public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer business_id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String adress;


    @NotNull
    @Column(nullable = false)
    private String times;

    @NotNull
    @Column(nullable = false)
    private String description;


    //Bewertungen

    @OneToMany
    private Rating rating;

    //Getränke
    @OneToMany
    private Beverage beverage;
}

