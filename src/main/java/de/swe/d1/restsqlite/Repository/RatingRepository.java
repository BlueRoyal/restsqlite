package de.swe.d1.restsqlite.Repository;

import de.swe.d1.restsqlite.Models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    Rating save(Rating rating);

    List<Rating> findAll();

    @Query(value = "SELECT * FROM Rating r WHERE r.text = ?1",
            nativeQuery = true)
    List<Rating> findAllByFilter( String parameter);

    void deleteById(Integer id);


}
