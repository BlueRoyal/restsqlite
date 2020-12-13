package de.swe.d1.restsqlite.Service;



import de.swe.d1.restsqlite.Models.Rating;


import java.util.List;

public interface RatingService {
    List<Rating> findAll();
    List<Rating> findAllByFilter(String filter);
    Rating deleteById(Integer id);
    Rating saveBusiness();
}
