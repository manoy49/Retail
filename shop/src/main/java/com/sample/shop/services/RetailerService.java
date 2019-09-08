package com.sample.shop.services;

import com.sample.shop.Response;
import com.sample.shop.entity.Retailer;
import com.sample.shop.serviceImpl.RetailerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class RetailerService {

    @Autowired
    RetailerServiceImpl retailerServiceImpl;

    public Response getAllRetailerInfo() {

        if(retailerServiceImpl.findALL() == null)
            return new Response(HttpStatus.NO_CONTENT, Response.DATA_NOT_FOUND, Response.ERRORS, null);
        else
            return new Response(HttpStatus.ACCEPTED, Response.SUCCESS, Response.ERRORS, retailerServiceImpl.findALL());
    }

    public Response getRetailerById(Long id) {

        if(retailerServiceImpl.findRetailerByID(id) == null)
            return new Response(HttpStatus.NO_CONTENT, Response.DATA_NOT_FOUND, Response.ERRORS, null);
        else
            return new Response(HttpStatus.ACCEPTED, Response.SUCCESS, Response.ERRORS, retailerServiceImpl.findRetailerByID(id));
    }

    public Response registerRetailer(Retailer retailer) {
        String message = retailerServiceImpl.registerRetailer(retailer);
        if(!message.contains("created"))
            return new Response(HttpStatus.FOUND, Response.DATA_EXISTS, Response.ERRORS, message);
        else
            return new Response(HttpStatus.CREATED, Response.SUCCESS, Response.ERRORS, message);
    }

    public Response filterByCategory(String store_type) {

        if(retailerServiceImpl.filterByCategory(store_type) != null)
            return new Response(HttpStatus.ACCEPTED, Response.SUCCESS, Response.ERRORS, retailerServiceImpl.filterByCategory(store_type));
        else
            return new Response(HttpStatus.NO_CONTENT, Response.DATA_NOT_FOUND, Response.ERRORS, null);
    }

    public Response getAllRetailerInfoWithPaging(Pageable pageable) {
        if(retailerServiceImpl.findALL(pageable) == null)
            return new Response(HttpStatus.NO_CONTENT, Response.DATA_NOT_FOUND, Response.ERRORS, null);
        else
            return new Response(HttpStatus.ACCEPTED, Response.SUCCESS, Response.ERRORS, retailerServiceImpl.findALL(pageable));
    }

    public Response updateRetailerInfo(Retailer retailer) {
        String message = retailerServiceImpl.updateRetailer(retailer);
        if(!message.contains("Updated"))
            return new Response(HttpStatus.NOT_MODIFIED, null, Response.ERRORS, message);
        else
            return new Response(HttpStatus.ACCEPTED, Response.SUCCESS, Response.ERRORS, message);
    }




}
