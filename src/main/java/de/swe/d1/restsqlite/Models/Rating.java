package de.swe.d1.restsqlite.Models;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer rating_id;

    @NotNull
    @Column(nullable = false)
    public String text;

    @NotNull
    @Column(nullable = false)
    public double rating;

    @NotNull
    @Column(nullable = false)
    public Integer user_id;

    @Column()
    public Integer beverage_id;

    @Column()
    public Integer business_id;

    @NotNull
    @Column(nullable = false)
    public String timestamp;

    //Getränke
   /* @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "beverage", insertable = false, updatable = false)
    private Collection<Beverage> beverage;

    //Getränke
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "business", insertable = false, updatable = false)
    private List<Business> business;
*/

}
