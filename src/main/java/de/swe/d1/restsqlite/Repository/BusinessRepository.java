package de.swe.d1.restsqlite.Repository;

import de.swe.d1.restsqlite.Models.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusinessRepository extends JpaRepository<Business, Integer> {
    Business save(Business business);

    List<Business> findAll();

    @Query(value = "SELECT * FROM business b WHERE b.name = ?1",
            nativeQuery = true)
    List<Business> findAllByFilter( String parameter);

    void deleteById( Integer id);


}
