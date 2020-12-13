package de.swe.d1.restsqlite.Service;

import de.swe.d1.restsqlite.Models.Beverage;


import java.util.List;

public interface BeverageService {


    List<Beverage> findAll();
    List<Beverage> findAllByFilter( String filter);
    Beverage deleteById(Integer id);
    Beverage saveBeverage();

}
