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
}
