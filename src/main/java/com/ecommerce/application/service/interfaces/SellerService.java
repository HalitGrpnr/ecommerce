package com.ecommerce.application.service.interfaces;

import com.ecommerce.application.domain.entity.Seller;

import java.util.List;

public interface SellerService {

    Seller get(Long id);
    Seller add(Seller Seller);
    Seller update(Seller Seller);
    void delete(Long id);
    List<Seller> getAll();



}
