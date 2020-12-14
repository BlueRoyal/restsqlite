package de.swe.d1.restsqlite.Service.Impl;

import de.swe.d1.restsqlite.Models.Rating;
import de.swe.d1.restsqlite.Repository.RatingRepository;
import de.swe.d1.restsqlite.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> findAllByFilter(String filter) {
        return ratingRepository.findAllByFilter(filter);
    }

    @Override
    public Rating deleteById(Integer id) {
        return null;
    }

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }
}
