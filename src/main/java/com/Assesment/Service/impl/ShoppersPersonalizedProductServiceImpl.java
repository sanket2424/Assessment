package com.Assesment.Service.impl;

import com.Assesment.Entity.ShoppersPersonalizedProduct;
import com.Assesment.Repository.ShopperPersonalizedProductRepository;
import com.Assesment.Service.ShoppersPersonalizedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppersPersonalizedProductServiceImpl implements ShoppersPersonalizedProductService {
    @Autowired
    private ShopperPersonalizedProductRepository repository;

    @Override
    public void saveShoppersPersonalizedProduct(ShoppersPersonalizedProduct personalizedProduct) {
        repository.save(personalizedProduct);
    }

    @Override
    public ShoppersPersonalizedProduct getShoppersPersonalizedProduct(String shopperId) {
        return repository.findById(shopperId).orElse(null);
    }
}