package com.sample.shop.controller;

import com.sample.shop.entity.Retailer;
import com.sample.shop.services.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/retailers")
public class RetailerController {

    @Autowired
    RetailerService retailerService;

    @GetMapping("/info")
    public ResponseEntity getAllRetailerInfo() {
        return new ResponseEntity(retailerService.getAllRetailerInfo(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/infoWithPaging")
    public ResponseEntity getAllRetailerInfoWithPagination(@RequestParam int page, @RequestParam int size)
    {
        return new ResponseEntity(retailerService.getAllRetailerInfoWithPaging(PageRequest.of(page, size)), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getRetailerById(@PathVariable Long id)
    {
        return new ResponseEntity(retailerService.getRetailerById(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/filterByCategory")
    public ResponseEntity filterByCategory(@RequestParam String store_type)
    {
        return new ResponseEntity(retailerService.filterByCategory(store_type), HttpStatus.ACCEPTED);
    }

    @PostMapping("/register")
    public ResponseEntity registerNewRetailer(@RequestBody Retailer retailer) {
        return new ResponseEntity(retailerService.registerRetailer(retailer), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateRetailerInfo(@RequestBody Retailer retailer)
    {
        return new ResponseEntity(retailerService.updateRetailerInfo(retailer), HttpStatus.CREATED);
    }





}
