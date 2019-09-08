package com.sample.shop.serviceImpl;

import com.sample.shop.entity.Retailer;
import com.sample.shop.repository.RetailerRepository;
import com.sample.shop.serviceAPI.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RetailerServiceImpl implements RetailerService {

    @Autowired
    public RetailerRepository retailer_repository;

    @Override
    public List<Retailer> findALL() {
        try {
            return retailer_repository.findAll();
        }catch (NullPointerException exception)
        {
            return null;
        }
    }

    @Override
    public Retailer findRetailerByID(Long id) {
        try {
            return retailer_repository.findRetailerByIdEquals(id);
        }catch (NullPointerException exception)
        {
            return null;
        }
    }

    @Override
    public String registerRetailer(Retailer retailer) {
        Retailer registered ;
        try {
            if(retailer_repository.findRetailerByPhoneNumberAndAndStoreAddress(retailer.getPhoneNumber(), retailer.getStoreAddress()) != null)
                return "Retailer with phone number " + retailer.getPhoneNumber() + " already registered";
            else
                registered =  retailer_repository.save(retailer);
        }catch (NullPointerException ex)
        {
            registered =  retailer_repository.save(retailer);
            return "created Retailer with id " + registered.getId();

        }
        return "created Retailer with id " + registered.getId();
    }

    @Override
    public List<Retailer> filterByCategory(String storeType) {
        try{
            return retailer_repository.findRetailerByStoreType(storeType);
        }catch (NullPointerException exception)
        {
            return null;
        }
    }

    @Override
    public List<Retailer> findALL(Pageable pageable) {
        try {
            return retailer_repository.findAll(pageable).stream().collect(Collectors.toList());
        }catch (Exception e)
        {
            if(e instanceof NullPointerException)
                return null;
            else
                throw e;
        }
    }

    @Override
    public String updateRetailer(Retailer retailer) {
        Retailer updatedRetailer;
        String message;
        try {
            if(retailer_repository.findRetailerByIdEquals(retailer.getId()) != null)
            {
                updatedRetailer = retailer_repository.save(retailer);
                message = "Updated Retailer having id " + updatedRetailer.getId();
            }
            else {
                message = "No Retailer Exists with this " + retailer.getId() + " id";
            }
        }catch (NullPointerException e)
        {
            message = "No Retailer Exists with this " + retailer.getId() + " id";

        }
        return message;
    }
}
