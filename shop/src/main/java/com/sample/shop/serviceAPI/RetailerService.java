package com.sample.shop.serviceAPI;
import com.sample.shop.entity.Retailer;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RetailerService {
     List<Retailer> findALL();
     Retailer findRetailerByID(Long id);
     String registerRetailer(Retailer retailer);
     List<Retailer> filterByCategory(String storeType);
     List<Retailer> findALL(Pageable pageable);
     String updateRetailer(Retailer retailer);
}
