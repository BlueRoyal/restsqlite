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
    @Column(nullable = false,unique = true)
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

    @NotNull
    @Column(nullable = false)
    public String telefon;

    @NotNull
    @Column(nullable = false)
    public String website;

    @Column()
    public String image;

    //Hacky
    @Column()
    public String beverages;

    @NotNull
    @Column(nullable = false)
    public int owner;

    //Bewertungen

    /*@OneToMany
    @JoinColumn(name = "rating", insertable = false, updatable = false)
    private List<Rating> rating;
*/
    //Getränke
    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "business")
    //@JoinColumn(name = "beverages", insertable = false, updatable = false)
    public List<Beverage> beverage;*/


}

