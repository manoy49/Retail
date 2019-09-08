package com.sample.shop.services;

import com.sample.shop.Response;
import com.sample.shop.entity.Store;
import com.sample.shop.serviceImpl.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    StoreServiceImpl storeServiceImpl;

    public Response getAllStoresInfo() {

        if(storeServiceImpl.findAll() == null)
            return new Response(HttpStatus.NO_CONTENT, Response.DATA_NOT_FOUND, Response.ERRORS, null);
        else
            return new Response(HttpStatus.ACCEPTED, Response.SUCCESS, Response.ERRORS, storeServiceImpl.findAll());
    }

    public Response getAllStoresInfo(Pageable pageable) {

        if(storeServiceImpl.findAll(pageable) == null)
            return new Response(HttpStatus.NO_CONTENT, Response.DATA_NOT_FOUND, Response.ERRORS, null);
        else
            return new Response(HttpStatus.ACCEPTED, Response.SUCCESS, Response.ERRORS, storeServiceImpl.findAll(pageable));
    }

    public Response getStoreById(Long id) {

        if(storeServiceImpl.findStoreById(id) == null)
            return new Response(HttpStatus.NO_CONTENT, Response.DATA_NOT_FOUND, Response.ERRORS, null);
        else
            return new Response(HttpStatus.ACCEPTED, Response.SUCCESS, Response.ERRORS, storeServiceImpl.findStoreById(id));
    }


    public Response getStoresByRetailerId(Long retailer_id) {

        if(storeServiceImpl.findStoreForRetailer(retailer_id) == null)
            return new Response(HttpStatus.NO_CONTENT, Response.DATA_NOT_FOUND, Response.ERRORS, null);
        else
            return new Response(HttpStatus.ACCEPTED, Response.SUCCESS, Response.ERRORS, storeServiceImpl.findStoreForRetailer(retailer_id));
    }

    public Response registerStore(Store store)
    {
        String message = storeServiceImpl.registerStore(store);
        if(!message.contains("created"))
            return new Response(HttpStatus.FOUND, Response.DATA_EXISTS, Response.ERRORS, message);
        else
            return new Response(HttpStatus.CREATED, Response.SUCCESS, Response.ERRORS, message);
    }

    public Response updateStore(Store store)
    {
        String message = storeServiceImpl.updateStore(store);
        if(!message.contains("updated"))
            return new Response(HttpStatus.NOT_MODIFIED, null, Response.ERRORS, message);
        else
            return new Response(HttpStatus.CREATED, Response.SUCCESS, Response.ERRORS, message);
    }

}
