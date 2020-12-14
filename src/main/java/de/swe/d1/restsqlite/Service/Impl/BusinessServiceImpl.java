package de.swe.d1.restsqlite.Service.Impl;

import de.swe.d1.restsqlite.Models.Business;
import de.swe.d1.restsqlite.Repository.BusinessRepository;
import de.swe.d1.restsqlite.Service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    @Override
    public List<Business> findAll() {
        return businessRepository.findAll();
    }

    @Override
    public List<Business> findAllByFilter(String filter) {
        return businessRepository.findAllByFilter(filter);
    }

    @Override
    public Business deleteByName(String name) {
        return null;
    }

    @Override
    public Business saveBusiness( Business business) {
        return businessRepository.save(business);
    }
}
