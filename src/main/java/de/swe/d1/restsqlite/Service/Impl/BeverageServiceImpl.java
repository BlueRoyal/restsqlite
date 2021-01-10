package de.swe.d1.restsqlite.Service.Impl;

import de.swe.d1.restsqlite.Models.Beverage;
import de.swe.d1.restsqlite.Repository.BeverageRepository;
import de.swe.d1.restsqlite.Service.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BeverageServiceImpl implements BeverageService {

    @Autowired
    private BeverageRepository beverageRepository;

    @Override
    public List<Beverage> findAll() {
        return beverageRepository.findAll();
    }

    @Override
    public List<Beverage> findAllByFilter(String filter) {
        return beverageRepository.findAllByFilter(filter);
    }

    @Override
    public void deleteById(Integer id) {
          beverageRepository.deleteById( id);
    }

    @Override
    public Beverage saveBeverage(Beverage beverage) {
        return beverageRepository.save(beverage);
    }

    @Override
    public Beverage updateBeverage(Beverage beverage) {
        if( beverage.name != ""){
            beverageRepository.updateName(beverage.beverage_id,beverage.name);
        }
        if(beverage.type != "") {
            beverageRepository.updateType(beverage.beverage_id, beverage.type);
        }
        if(beverage.origin != ""){
            beverageRepository.updateOrigin(beverage.beverage_id,beverage.origin);
        }
        if(beverage.ingredients != ""){
            beverageRepository.updateIngredients(beverage.beverage_id,beverage.ingredients);
        }
        if(beverage.art != ""){
            beverageRepository.updateArt(beverage.beverage_id, beverage.art);
        }
        if(beverage.alcohol != 0.0){
            beverageRepository.updateAlcohol(beverage.beverage_id,beverage.alcohol);
        }
        if(beverage.allergenes != null) {
            beverageRepository.updateAllergenes(beverage.beverage_id, beverage.allergenes);
        }
        if(beverage.description != ""){
            beverageRepository.updateTDescription(beverage.beverage_id,beverage.description);
        }
        if(beverage.image != ""){
            beverageRepository.updateImage(beverage.beverage_id,beverage.image);
        }
        if(beverage.ean != ""){
            beverageRepository.updateEAN(beverage.beverage_id,beverage.ean);
        }

      return beverage;
    }
}
