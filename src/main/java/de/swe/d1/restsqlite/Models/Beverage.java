package de.swe.d1.restsqlite.Models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Beverage")
public class Beverage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer beverage_id;

    @NotNull
    @Column(nullable = false)
    String name;

    @NotNull
    @Column(nullable = false)
    String type;

    @NotNull
    @Column(nullable = false)
    String description;

    @NotNull
    @Column(nullable = false)
    String image;

    @NotNull
    @Column(nullable = false)
    String ean;


}
