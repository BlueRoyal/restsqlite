package de.swe.d1.restsqlite.Controller;

import de.swe.d1.restsqlite.Models.Beverage;
import de.swe.d1.restsqlite.Models.Business;
import de.swe.d1.restsqlite.Models.Rating;
import de.swe.d1.restsqlite.Models.User;
import de.swe.d1.restsqlite.Service.BeverageService;
import de.swe.d1.restsqlite.Service.BusinessService;
import de.swe.d1.restsqlite.Service.RatingService;
import de.swe.d1.restsqlite.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.List;


@RestController

@RequestMapping("/cybersommelie")
public class MainRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private RatingService ratingService;
    @Autowired
    private BusinessService businessService;
    @Autowired
    private BeverageService beverageService;

    @CrossOrigin
    @RequestMapping(value="/user/getAll", method = RequestMethod.GET)
    public List<User> getAllUser(){
       return userService.findAll();
    }
    @CrossOrigin
    @RequestMapping(value="/beverage/getAll", method = RequestMethod.GET)
    public List<Beverage> getAllBeverage(){
      return beverageService.findAll();
    }
    @CrossOrigin
    @RequestMapping(value="/business/getAll", method = RequestMethod.GET)
    public List<Business> getAllBusiness(){
      return businessService.findAll();
    }
    @CrossOrigin
    @RequestMapping(value="/rating/getAll", method = RequestMethod.GET)
    public List<Rating> getAllRating(){
        return ratingService.findAll();
    }
    @CrossOrigin
    @RequestMapping(value="/user/get/{parameter}", method = RequestMethod.GET)
    public List<User> getUser(@PathVariable("parameter") String parameter){
       return userService.findAllByFilter(parameter);

    }
    @CrossOrigin
    @RequestMapping(value="/beverage/get/{parameter}", method = RequestMethod.GET)
    public List<Beverage> getBeverage(@PathVariable("parameter") String parameter){
        return  beverageService.findAllByFilter(parameter);
    }
    @CrossOrigin
    @RequestMapping(value="/business/get/{parameter}", method = RequestMethod.GET)
    public List<Business> getBusiness(@PathVariable("parameter") String parameter){
        return businessService.findAllByFilter(parameter);
    }
    @CrossOrigin
    @RequestMapping(value="/user/check", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUser(@RequestBody User user){


        System.out.println(user.email);
        BCryptPasswordEncoder bCryptPasswordEncoder =
                new BCryptPasswordEncoder(10, new SecureRandom());

        if( userService.findAllByFilter(user.email).size() > 0 ) {

            System.out.println();
            if (bCryptPasswordEncoder.matches(user.password, userService.findAllByFilter(user.email).get(0).password)) {
                return "{\"status\":\"" + true + "\", \"msg\":\"Passwort richtig\"}";
            } else {
                return "{\"status\":\"" + false + "\", \"msg\":\"Passwort falsch\"}";
            }
        }
        return "{\"status\":\"" + false + "\", \"msg\":\"Passwort falsch\"}";
    }


    // BCrypt password
    @CrossOrigin
    @RequestMapping(value = "/user/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    User saveUser(@RequestBody User user){
        try {
            User save = new User(user.email, user.password, user.type, user.birthday);
            return userService.saveUser(save);
        }catch(Exception e){
            return new User();
        }
    }

    //Getränk hinzufügen
    @CrossOrigin
    @RequestMapping(value = "/beverage/add", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    Beverage saveBeverage(@RequestBody Beverage beverage){
        try{
            return beverageService.saveBeverage(beverage);
        }catch(Exception e){
            return new Beverage();
        }

    }

    //Geschäft hinzufügen
    @CrossOrigin
    @RequestMapping(value = "/business/add", method = RequestMethod.POST)
    Business saveBusiness(@RequestBody Business business){
        try{
            return businessService.saveBusiness(business);
        }catch(Exception e){
            return new Business();
        }

    }

    //Geschäft hinzufügen
    @CrossOrigin
    @RequestMapping(value = "/rating/add", method = RequestMethod.POST)
    Rating saveRating(@RequestBody Rating rating){
        try{
            return ratingService.saveRating(rating);
        }catch(Exception e){
            return new Rating();
        }

    }



    ///update
    @CrossOrigin
    @RequestMapping(value = "/user/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    //Getränk hinzufügen
    @CrossOrigin
    @RequestMapping(value = "/beverage/update", method = RequestMethod.POST)
    Beverage updateBeverage(@RequestBody Beverage beverage){

        return beverageService.updateBeverage(beverage);
    }

    //Geschäft hinzufügen
    @CrossOrigin
    @RequestMapping(value = "/business/update", method = RequestMethod.POST)
    Business updateBusiness(@RequestBody Business business){
        return null;// businessService.updateBusiness(business);
    }

    //Geschäft hinzufügen
    @CrossOrigin
    @RequestMapping(value = "/rating/update", method = RequestMethod.POST)
    Rating updateRating(@RequestBody Rating rating){
        return null;//return ratingService.updateRating(rating);
    }

    //Löschmethoden ? Wers braucht




    ///update
    @CrossOrigin
    @RequestMapping(value = "/user/delete/{parameter}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteUser(@PathVariable("parameter") String parameter){
        userService.deleteById( Integer.getInteger(parameter) );
    }

    //Getränk hinzufügen
    @CrossOrigin
    @RequestMapping(value = "/beverage/delete/{parameter}", method = RequestMethod.POST)
    void deleteBeverage(@PathVariable("parameter") String parameter){
        beverageService.deleteById( Integer.getInteger(parameter) );
    }

    //Geschäft hinzufügen
    @CrossOrigin
    @RequestMapping(value = "/business/delete/{parameter}", method = RequestMethod.POST)
    void deleteBusiness(@PathVariable("parameter") String parameter){
        businessService.deleteById( Integer.getInteger(parameter) );
    }

    //Geschäft hinzufügen
    @CrossOrigin
    @RequestMapping(value = "/rating/delete/{parameter}", method = RequestMethod.POST)
    void deleteRating(@PathVariable("parameter") String parameter){
        ratingService.deleteById( Integer.getInteger(parameter) );
    }

    //Löschmethoden ? Wers braucht

}