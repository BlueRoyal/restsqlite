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
    public Integer business_id;

    @NotNull
    @Column(nullable = false)
    public String name;

    @NotNull
    @Column(nullable = false)
    public String adress;

    @NotNull
    @Column(nullable = false)
    public String times;

    @NotNull
    @Column(nullable = false)
    public String description;


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

