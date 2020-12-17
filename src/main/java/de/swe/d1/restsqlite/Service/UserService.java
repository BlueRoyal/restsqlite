package de.swe.d1.restsqlite.Service;



import de.swe.d1.restsqlite.Models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    List<User> findAllByFilter(String filter);
    User deleteByEmail(String email);
    User saveUser( User user);
    void updateUser(User user);

}
