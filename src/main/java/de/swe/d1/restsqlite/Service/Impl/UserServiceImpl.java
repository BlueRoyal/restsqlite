package de.swe.d1.restsqlite.Service.Impl;

import de.swe.d1.restsqlite.Models.User;
import de.swe.d1.restsqlite.Repository.UserRepository;
import de.swe.d1.restsqlite.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllByFilter(String filter) {
       return userRepository.findAllByFilter(filter);
    }

    @Override
    public User deleteByEmail(String email) {
        return userRepository.deleteByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if( user.email != ""){
            userRepository.updateEmail(user.user_id,user.email);
        }
        if(user.password != "") {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
            String encodedPassword = bCryptPasswordEncoder.encode(user.password);
            userRepository.updatePassword(user.user_id, encodedPassword);
        }
        if(user.birthday != ""){
            userRepository.updateBirthday(user.user_id, user.birthday);
        }
        return user;
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
