package com.sample.shop.serviceImpl;

import com.sample.shop.entity.Store;
import com.sample.shop.repository.StoreRepository;
import com.sample.shop.serviceAPI.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StoreServiceImpl implements StoreService {

    @Autowired
    public StoreRepository store_repository;

    @Override
    public List<Store> findAll(Pageable pageable) {
        try {
            return store_repository.findAll(pageable).stream().collect(Collectors.toList());
        }catch (Exception e)
        {
            if(e instanceof NullPointerException)
                return null;
            else
                throw e;
        }
    }

    @Override
    public String updateStore(Store store) {
        Store updated;
        try {
            if(store_repository.findStoreByStoreIdEquals(store.getStoreId()) != null)
               updated =  store_repository.save(store);
            else
              return "No Store exists with id " + store.getRetailer().getId();
        }catch (NullPointerException e)
        {
            return "No Store exists with id " + store.getRetailer().getId();
        }
        return "updated store having id " + updated.getStoreId();
    }

    @Override
    public List<Store> findAll() {
        try {
            return store_repository.findAll();
        }catch (NullPointerException e)
        {
            return null;
        }
    }

    @Override
    public Store findStoreById(Long storeId) {
        try {
            return store_repository.findStoreByStoreIdEquals(storeId);
        }catch (NullPointerException e)
        {
            return null;
        }
    }

    @Override
    public String registerStore(Store store) {
        Store registered;
        try {
            if(store_repository.findStoreByStoreIdEquals(store.getStoreId()) != null)
                return "store already registered under Retailer with id " + store.getRetailer().getId() + "and with name "
                        + store.getName();
            else
                registered = store_repository.save(store);
        }catch (NullPointerException e)
        {
            registered = store_repository.save(store);

        }
        return "store created under Retailer havind id " + registered.getRetailer().getId() + " with name '" + registered.getName() + "'";
    }

    @Override
    public List<Store> findStoreForRetailer(Long id) {
        try{
            return store_repository.findAllByRetailerId(id);
        }catch (NullPointerException e)
        {
            return null;
        }
    }
}
