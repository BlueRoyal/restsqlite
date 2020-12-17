package de.swe.d1.restsqlite.Repository;
import de.swe.d1.restsqlite.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User save(User user);

    List<User> findAll();

    @Query(value = "SELECT * FROM User u WHERE u.email = ?1",
    nativeQuery = true)
    List<User> findAllByFilter( String parameter);

    User deleteByEmail( String email);
    @Query(value = "SELECT * FROM User u WHERE u.email = ?1",nativeQuery = true)
    void updateUser(User user);



}
