package de.swe.d1.restsqlite.Models;

import com.sun.istack.NotNull;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Business")
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

    /*@OneToMany
    @JoinColumn(name = "rating", insertable = false, updatable = false)
    private List<Rating> rating;

    //Getränke
    @OneToMany
    @JoinColumn(name = "beverage", insertable = false, updatable = false)
    private List<Beverage> beverage;
*/

}

