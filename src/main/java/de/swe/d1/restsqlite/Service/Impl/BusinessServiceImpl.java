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

    @Override
    public Business updateBusiness(Business business) {
        if( business.name != ""){
            businessRepository.updateName(business.business_id, business.name);
        }
        if( business.adress != ""){
            businessRepository.updateAdress(business.business_id, business.adress);
        }
        if( business.times != ""){
            businessRepository.updateTimes(business.business_id, business.times);
        }
        if( business.description != ""){
            businessRepository.updateDescription(business.business_id, business.description);
        }
        if( business.telefon != ""){
            businessRepository.updateTele(business.business_id, business.telefon);
        }
        if( business.website != null){
            businessRepository.updateWeb(business.business_id, business.website);
        }
        if( business.beverages != null){
            businessRepository.updateBeverages(business.business_id, business.beverages);
        }
        if( business.owner != 0){
            businessRepository.updateOwner(business.business_id, business.owner);
        }
        if( business.image != ""){
            businessRepository.updateImage(business.business_id, business.image);
        }
        return business;
    }
    @Override
    public void deleteById(Integer id) {
        businessRepository.deleteById(id);
    }
}
