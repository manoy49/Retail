package com.sample.shop.repository;

import com.sample.shop.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long>, PagingAndSortingRepository<Store, Long> {

    Store findStoreByStoreIdEquals(Long storeId);

    List<Store> findAllByRetailerId(Long id);

    List<Store> findAll();

    Page<Store> findAll(Pageable pageable);

}
