package de.swe.d1.restsqlite.Models;

import com.sun.istack.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.security.SecureRandom;
import java.util.List;

@Entity
@Table(name = "User")
//TODO  : [SQLITE_ERROR] SQL error or missing database (table user has no column named user_id)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer user_id;

    @NotNull

    @Column(nullable = false, unique = true)
    public String email;

    @NotNull
    @Column(nullable = false)
   public String password;

    @Column
    public String name;

    @Column()
    public Integer type;

   // @NotNull
    @Column()
    public String birthday;

    @Column()
    public String favorit_beverage;

    @Column()
    public String favorit_business;

    public User() {

    }

    public User(String name,String email, String password, Integer type, String birthday, String favorit_business, String favorit_beverage) {
                BCryptPasswordEncoder bCryptPasswordEncoder =
                new BCryptPasswordEncoder(10, new SecureRandom());
                 String encodedPassword = bCryptPasswordEncoder.encode(password);
        this.email = email;
        this.password = encodedPassword;
        this.type = type;
        this.birthday = birthday;
        this.name = name;
        this.favorit_beverage = favorit_beverage;
        this.favorit_business = favorit_business;

    }

private void Test(){

}

   /* @ManyToOne
    @JoinColumn(name = "business", insertable = false, updatable = false)
    private List<Business> business;

    @ManyToOne
    @JoinColumn(name = "ratings", insertable = false, updatable = false)
    private List<Rating> ratings;
*/
}
