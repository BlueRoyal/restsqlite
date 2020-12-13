package de.swe.d1.restsqlite.Models;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
