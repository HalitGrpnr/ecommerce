package com.ecommerce.application.service.interfaces;

import com.ecommerce.application.domain.entity.Store;

import java.util.List;

public interface StoreService {

    Store get(Long id);
    Store add(Store Store);
    Store update(Store Store);
    void delete(Long id);
    List<Store> getAll();



}
