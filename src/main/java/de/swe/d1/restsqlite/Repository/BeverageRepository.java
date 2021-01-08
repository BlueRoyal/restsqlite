package de.swe.d1.restsqlite.Repository;

import de.swe.d1.restsqlite.Models.Beverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BeverageRepository extends JpaRepository<Beverage, Integer> {
    Beverage save(Beverage beverage);

    List<Beverage> findAll();

    @Query(value = "SELECT * FROM beverage b WHERE b.name = ?1",
            nativeQuery = true)
    List<Beverage> findAllByFilter( String parameter);

    void deleteById( Integer id);

}
