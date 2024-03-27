package com.Assesment.Service;

import com.Assesment.Entity.ProductMetadata;

import java.util.List;

public interface ProductService {
    List<ProductMetadata> getProductsByShopper(String shopperId, String category, String brand, int limit);
}
