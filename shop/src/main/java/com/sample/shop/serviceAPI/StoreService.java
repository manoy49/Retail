package com.sample.shop.serviceAPI;
import com.sample.shop.entity.Store;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StoreService {

    List<Store> findAll();
    Store findStoreById(Long storeId);
    String registerStore(Store store);
    List<Store> findStoreForRetailer(Long id);
    List<Store> findAll(Pageable pageable);
    String updateStore(Store store);


}
