package de.swe.d1.restsqlite.Controller;

import de.swe.d1.restsqlite.Models.Beverage;
import de.swe.d1.restsqlite.Models.Business;
import de.swe.d1.restsqlite.Models.Rating;
import de.swe.d1.restsqlite.Models.User;
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

    // User Exists?
    @RequestMapping(value="/user/get/{parameter}", method = RequestMethod.GET)
    public List<User> getUser(@PathVariable("parameter") String parameter){
        //TODO CODE HERE
        List<User> lis = null;
        return lis;
    }

    @RequestMapping(value="/beverage/get/{parameter}", method = RequestMethod.GET)
    public List<Beverage> getBeverage(@PathVariable("parameter") String parameter){
        //TODO CODE HERE
        List<Beverage> lis = null;
        return lis;
    }

    @RequestMapping(value="/business/get/{parameter}", method = RequestMethod.GET)
    public List<Business> getBusiness(@PathVariable("parameter") String parameter){
        //TODO CODE HERE
        List<Business> lis = null;
        return lis;
    }

    @RequestMapping(value="/rating/get/{parameter}", method = RequestMethod.GET)
    public List<Rating> getRating(@PathVariable("parameter") String parameter){
        //TODO CODE HERE
        List<Rating> lis = null;
        return lis;
    }

    //Neuen Benutzer anlegen
    // BCrypt
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    User saveUser(@RequestBody User user){
        //TODO CODE HERE
        return new User();
    }

    //Getränk hinzufügen
    @RequestMapping(value = "/beverage/add", method = RequestMethod.POST)
    Beverage saveBeverage(@RequestBody Beverage beverage){
        //TODO CODE HERE
        return new Beverage();
    }

    //Geschäft hinzufügen
    @RequestMapping(value = "/business/add", method = RequestMethod.POST)
    Business saveBusiness(@RequestBody Business business){
        //TODO CODE HERE
        return new Business();
    }

    //Geschäft hinzufügen
    @RequestMapping(value = "/rating/add", method = RequestMethod.POST)
    Rating saveRating(@RequestBody Business business){
        //TODO CODE HERE
        return new Rating();
    }

}
