package de.swe.d1.restsqlite.Service;


import de.swe.d1.restsqlite.Models.Business;


import java.util.List;

public interface BusinessService {
    List<Business> findAll();
    List<Business> findAllByFilter( String filter);
    Business deleteByName(String name);
    Business saveBusiness();
}
