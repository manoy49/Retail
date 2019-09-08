package com.sample.shop.controller;

import com.sample.shop.entity.Retailer;
import com.sample.shop.entity.Store;
import com.sample.shop.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping("/list")
    public ResponseEntity getAllStoresList() {
        return new ResponseEntity(storeService.getAllStoresInfo(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/infoWithPaging")
    public ResponseEntity getAllStoresInfoWithPagination(@RequestParam int page, @RequestParam int size)
    {
        return new ResponseEntity(storeService.getAllStoresInfo(PageRequest.of(page, size)), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getStoreById(@PathVariable Long id)
    {
        return new ResponseEntity(storeService.getStoreById(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/ByRetailer/{retailer_id}")
    public ResponseEntity filterByCategory(@PathVariable Long retailer_id)
    {
        return new ResponseEntity(storeService.getStoresByRetailerId(retailer_id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/register")
    public ResponseEntity registerNewStore(@RequestBody Store store) {
        return new ResponseEntity(storeService.registerStore(store), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateStoreInfo(@RequestBody Store store)
    {
        return new ResponseEntity(storeService.updateStore(store), HttpStatus.CREATED);
    }
}
