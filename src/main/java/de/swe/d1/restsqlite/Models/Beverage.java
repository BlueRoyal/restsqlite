package de.swe.d1.restsqlite.Models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Beverage")
public class Beverage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer beverage_id;

    @Column()
    public String name;

    @Column()
    public String type;


    @Column()
    public String description;

    @Column()
    public String image;


    @Column()
    public String ean;


}
