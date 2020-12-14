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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping(value="/user/getAll", method = RequestMethod.GET)
    public List<User> getAllUser(){
       return userService.findAll();
    }

    @RequestMapping(value="/beverage/getAll", method = RequestMethod.GET)
    public List<Beverage> getAllBeverage(){
      return beverageService.findAll();
    }

    @RequestMapping(value="/business/getAll", method = RequestMethod.GET)
    public List<Business> getAllBusiness(){
      return businessService.findAll();
    }

    @RequestMapping(value="/rating/getAll", method = RequestMethod.GET)
    public List<Rating> getAllRating(){
        return ratingService.findAll();
    }

    @RequestMapping(value="/user/get/{parameter}", method = RequestMethod.GET)
    public List<User> getUser(@PathVariable("parameter") String parameter){
       return userService.findAllByFilter(parameter);

    }

    @RequestMapping(value="/beverage/get/{parameter}", method = RequestMethod.GET)
    public List<Beverage> getBeverage(@PathVariable("parameter") String parameter){
        return  beverageService.findAllByFilter(parameter);
    }

    @RequestMapping(value="/business/get/{parameter}", method = RequestMethod.GET)
    public List<Business> getBusiness(@PathVariable("parameter") String parameter){
        return businessService.findAllByFilter(parameter);
    }

    @RequestMapping(value="/rating/get/{parameter}", method = RequestMethod.GET)
    public List<Rating> getRating(@PathVariable("parameter") String parameter){
        return ratingService.findAllByFilter(parameter);
    }


    // BCrypt password
    @RequestMapping(value = "/user/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    User saveUser(@RequestBody User user){
       return userService.saveUser(user);
    }

    //Getränk hinzufügen
    @RequestMapping(value = "/beverage/add", method = RequestMethod.POST)
    Beverage saveBeverage(@RequestBody Beverage beverage){
      return beverageService.saveBeverage(beverage);
    }

    //Geschäft hinzufügen
    @RequestMapping(value = "/business/add", method = RequestMethod.POST)
    Business saveBusiness(@RequestBody Business business){
        return businessService.saveBusiness(business);
    }

    //Geschäft hinzufügen
    @RequestMapping(value = "/rating/add", method = RequestMethod.POST)
    Rating saveRating(@RequestBody Rating rating){
        return ratingService.saveRating(rating);
    }


    //Löschmethoden ? Wers braucht

}
