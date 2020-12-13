package de.swe.d1.restsqlite.Models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer user_id;

    @NotNull
    @Column(nullable = false)
    String email;

    @NotNull
    @Column(nullable = false)
    String password;

    @NotNull
    @Column(nullable = false)
    String birthday;

    @ManyToOne
    private List<Business> business;

    @ManyToOne
    private List<Rating> ratings;

}
