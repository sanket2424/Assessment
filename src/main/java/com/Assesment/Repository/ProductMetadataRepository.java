package com.Assesment.Repository;

import com.Assesment.Entity.ProductMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductMetadataRepository extends JpaRepository<ProductMetadata, String> {
    List<ProductMetadata> findByCategory(String category);

    List<ProductMetadata> findByBrand(String brand);

    List<ProductMetadata> findByCategoryAndBrand(String category, String brand);

    List<ProductMetadata> findByCategoryAndProductIdIn(String category, List<String> productIds);

    List<ProductMetadata> findByBrandAndProductIdIn(String brand, List<String> productIds);

    List<ProductMetadata> findByCategoryAndBrandAndProductIdIn(String category, String brand, List<String> productIds);
}

