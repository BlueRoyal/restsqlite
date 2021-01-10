package de.swe.d1.restsqlite.Repository;

import de.swe.d1.restsqlite.Models.Beverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BeverageRepository extends JpaRepository<Beverage, Integer> {
    Beverage save(Beverage beverage);

    List<Beverage> findAll();

    @Query(value = "SELECT * FROM beverage b WHERE b.name = ?1",
            nativeQuery = true)
    List<Beverage> findAllByFilter( String parameter);

    void deleteById( Integer id);


    @Modifying
    @Transactional
    @Query("update Beverage b set b.name = :name where b.beverage_id = :id")
    void updateName(@Param(value = "id") Integer id, @Param(value = "name") String name);

    @Modifying
    @Transactional
    @Query("update Beverage b set b.type = :type where b.beverage_id = :id")
    void updateType(@Param(value = "id") Integer id, @Param(value = "type") String type);

    @Modifying
    @Transactional
    @Query("update Beverage b set b.art = :art where b.beverage_id = :id")
    void updateArt(@Param(value = "id") Integer id, @Param(value = "art") String art);

    @Modifying
    @Transactional
    @Query("update Beverage b set b.origin = :origin where b.beverage_id = :id")
    void updateOrigin(@Param(value = "id") Integer id, @Param(value = "origin") String origin);

    @Modifying
    @Transactional
    @Query("update Beverage b set b.ingredients = :ing where b.beverage_id = :id")
    void updateIngredients(@Param(value = "id") Integer id, @Param(value = "ing") String ing);

    @Modifying
    @Transactional
    @Query("update Beverage b set b.alcohol = :alcohol where b.beverage_id = :id")
    void updateAlcohol(@Param(value = "id") Integer id, @Param(value = "alcohol") double alcohol);

    @Modifying
    @Transactional
    @Query("update Beverage b set b.allergenes = :aller where b.beverage_id = :id")
    void updateAllergenes(@Param(value = "id") Integer id, @Param(value = "aller") Boolean aller);

    @Modifying
    @Transactional
    @Query("update Beverage b set b.description = :desc where b.beverage_id = :id")
    void updateTDescription(@Param(value = "id") Integer id, @Param(value = "desc") String desc);

    @Modifying
    @Transactional
    @Query("update Beverage b set b.image = :img where b.beverage_id = :id")
    void updateImage(@Param(value = "id") Integer id, @Param(value = "img") String img);

    @Modifying
    @Transactional
    @Query("update Beverage b set b.ean = :ean where b.beverage_id = :id")
    void updateEAN(@Param(value = "id") Integer id, @Param(value = "ean") String ean);




}
