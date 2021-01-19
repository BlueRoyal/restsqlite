package de.swe.d1.restsqlite.Repository;

import de.swe.d1.restsqlite.Models.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BusinessRepository extends JpaRepository<Business, Integer> {
    Business save(Business business);

    List<Business> findAll();

    @Query(value = "SELECT * FROM business b WHERE b.name = ?1",
            nativeQuery = true)
    List<Business> findAllByFilter( String parameter);

    void deleteById( Integer id);

    @Modifying
    @Transactional
    @Query("update Business b set b.name = :name where b.business_id = :id")
    void updateName(@Param(value = "id") Integer id, @Param(value = "name") String name);

    @Modifying
    @Transactional
    @Query("update Business b set b.image = :img where b.business_id = :id")
    void updateImage(@Param(value = "id") Integer id, @Param(value = "img") String img);

    @Modifying
    @Transactional
    @Query("update Business b set b.adress = :adress where b.business_id = :id")
    void updateAdress(@Param(value = "id") Integer id, @Param(value = "adress") String adress);

    @Modifying
    @Transactional
    @Query("update Business b set b.times = :times where b.business_id = :id")
    void updateTimes(@Param(value = "id") Integer id, @Param(value = "times") String times);

    @Modifying
    @Transactional
    @Query("update Business b set b.description = :desc where b.business_id = :id")
    void updateDescription(@Param(value = "id") Integer id, @Param(value = "desc") String desc);

    @Modifying
    @Transactional
    @Query("update Business b set b.telefon = :tele where b.business_id = :id")
    void updateTele(@Param(value = "id") Integer id, @Param(value = "tele") String tele);

    @Modifying
    @Transactional
    @Query("update Business b set b.website = :web where b.business_id = :id")
    void updateWeb(@Param(value = "id") Integer id, @Param(value = "web") String web);

    @Modifying
    @Transactional
    @Query("update Business b set b.beverages = :bev where b.business_id = :id")
    void updateBeverages(@Param(value = "id") Integer id, @Param(value = "bev") String bev);

    @Modifying
    @Transactional
    @Query("update Business b set b.owner = :owner where b.business_id = :id")
    void updateOwner(@Param(value = "id") Integer id, @Param(value = "owner") Integer owner);


}
