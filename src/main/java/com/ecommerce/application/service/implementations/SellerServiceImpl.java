package com.ecommerce.application.service.implementations;

import com.ecommerce.application.domain.entity.Seller;
import com.ecommerce.application.domain.entity.Store;
import com.ecommerce.application.repository.SellerRepository;
import com.ecommerce.application.service.interfaces.SellerService;
import com.ecommerce.application.service.interfaces.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private StoreService storeService;

    @Override
    public Seller get(Long id) {
        return sellerRepository.findById(id).orElse(new Seller());
    }

    @Override
    public Seller add(Seller seller) {
        Store store = new Store();
        store.setName("");
        Store createdStore = storeService.add(store);

        seller.setStore(createdStore);

        return sellerRepository.save(seller);
    }

    @Override
    public Seller update(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public void delete(Long id) {
        sellerRepository.deleteById(id);
    }

    @Override
    public List<Seller> getAll() {
        return sellerRepository.findAll();

    }
}
