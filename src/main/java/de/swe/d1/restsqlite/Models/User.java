package de.swe.d1.restsqlite.Models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "User")
//TODO  : [SQLITE_ERROR] SQL error or missing database (table user has no column named user_id)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer user_id;

    @NotNull
    @Column(nullable = false)
    public String email;

    @NotNull
    @Column(nullable = false)
   public String password;

   // @NotNull
    @Column()
    public String birthday;

   /* @ManyToOne
    @JoinColumn(name = "business", insertable = false, updatable = false)
    private List<Business> business;

    @ManyToOne
    @JoinColumn(name = "ratings", insertable = false, updatable = false)
    private List<Rating> ratings;
*/
}
