package de.swe.d1.restsqlite.Service;



import de.swe.d1.restsqlite.Models.Beverage;
import de.swe.d1.restsqlite.Models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    List<User> findAllByFilter(String filter);
    void deleteById(Integer id);
    User deleteByEmail(String email);
    User saveUser( User user);
    User updateUser(User user);

}
