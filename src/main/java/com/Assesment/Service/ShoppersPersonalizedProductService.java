package com.Assesment.Service;

import com.Assesment.Entity.ShoppersPersonalizedProduct;

import java.util.List;

public interface ShoppersPersonalizedProductService {
    void saveShoppersPersonalizedProduct(ShoppersPersonalizedProduct personalizedProduct);
    ShoppersPersonalizedProduct getShoppersPersonalizedProduct(String shopperId);
}
