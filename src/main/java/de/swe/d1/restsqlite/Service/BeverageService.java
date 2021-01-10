package de.swe.d1.restsqlite.Service;
import de.swe.d1.restsqlite.Models.Beverage;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BeverageService {


    List<Beverage> findAll();
    List<Beverage> findAllByFilter( String filter);
    void deleteById(Integer id);
    Beverage saveBeverage(Beverage beverage);
    Beverage updateBeverage(Beverage beverage);

}
