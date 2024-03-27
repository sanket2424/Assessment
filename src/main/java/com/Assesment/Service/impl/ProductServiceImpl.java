package com.Assesment.Service.impl;

import com.Assesment.Entity.ProductMetadata;
import com.Assesment.Entity.ProductShelfItem;
import com.Assesment.Entity.ShoppersPersonalizedProduct;
import com.Assesment.Repository.ProductMetadataRepository;
import com.Assesment.Repository.ShopperPersonalizedProductRepository;
import com.Assesment.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMetadataRepository productMetadataRepository;

    @Autowired
    private ShopperPersonalizedProductRepository personalizedProductRepository;

    @Override
    public List<ProductMetadata> getProductsByShopper(String shopperId, String category, String brand, int limit) {

        ShoppersPersonalizedProduct personalizedProduct = personalizedProductRepository.findById(shopperId).orElse(null);
        if (personalizedProduct == null) {

            return Collections.emptyList();
        }


        List<ProductShelfItem> shelfItems = personalizedProduct.getShelf();


        shelfItems.sort(Comparator.comparing(ProductShelfItem::getRelevancyScore).reversed());


        List<String> productIds = shelfItems.stream().map(ProductShelfItem::getProductId).collect(Collectors.toList());


        List<ProductMetadata> products;
        if (category == null && brand == null) {
            products = productMetadataRepository.findAllById(productIds);
        } else if (category != null && brand == null) {
            products = productMetadataRepository.findByCategoryAndProductIdIn(category, productIds);
        } else if (category == null && brand != null) {
            products = productMetadataRepository.findByBrandAndProductIdIn(brand, productIds);
        } else {
            products = productMetadataRepository.findByCategoryAndBrandAndProductIdIn(category, brand, productIds);
        }


        if (products.size() > limit) {
            products = products.subList(0, limit);
        }

        return products;
    }
}
