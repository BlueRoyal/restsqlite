package de.swe.d1.restsqlite.Models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Beverage")
public class Beverage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer beverage_id;

    @Column(unique = true)
    public String name;

    @Column()
    public String type;


    @Column()
    public String description;

    @Column()
    public String image;


    @Column(unique = true)
    public String ean;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id")
    private Business business;*/
}
