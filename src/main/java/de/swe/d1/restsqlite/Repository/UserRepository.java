package de.swe.d1.restsqlite.Repository;
import com.sun.istack.NotNull;
import de.swe.d1.restsqlite.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User save(User user);

    List<User> findAll();

    @Query(value = "SELECT * FROM User u WHERE u.email = ?1",
    nativeQuery = true)
    List<User> findAllByFilter( String parameter);

    User deleteByEmail( String email);



    @Modifying
    @Transactional
    @Query("update User u set u.email = :email where u.user_id = :id")
    void updateEmail(@Param(value = "id") Integer id, @Param(value = "email") String email);

    @Modifying
    @Transactional
    @Query("update User u set u.password = :pwd where u.user_id = :id")
    void updatePassword(@Param(value = "id") Integer id, @Param(value = "pwd") String pwd);

    @Modifying
    @Transactional
    @Query("update User u set u.birthday = :bday where u.user_id = :id")
    void updateBirthday(@Param(value = "id") Integer id, @Param(value = "bday") String bday);



}
