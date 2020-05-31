package com.ecommerce.application.service.implementations;

import com.ecommerce.application.domain.entity.Store;
import com.ecommerce.application.repository.StoreRepository;
import com.ecommerce.application.service.interfaces.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Store get(Long id) {
        return storeRepository.findById(id).orElse(new Store());
    }

    @Override
    public Store add(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store update(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public void delete(Long id) {
        storeRepository.deleteById(id);
    }

    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }
}
