package com.sample.shop.repository;

import com.sample.shop.entity.Retailer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RetailerRepository extends CrudRepository<Retailer, Long>, PagingAndSortingRepository<Retailer, Long> {

    List<Retailer> findAll();

    Page<Retailer> findAll(Pageable pageable);

    Retailer findRetailerByIdEquals(Long id);

    @Query(value = "SELECT * from Retailer retailer where retailer.store_type=:storeType", nativeQuery = true)
    List<Retailer> findRetailerByStoreType(String storeType);

    Retailer findRetailerByPhoneNumberAndAndStoreAddress(String phoneNumber, String storeAddress);

    Retailer findRetailerByPhoneNumber(String phoneNumber);

}
