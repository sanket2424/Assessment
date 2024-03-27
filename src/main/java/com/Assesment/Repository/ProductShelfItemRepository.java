package com.Assesment.Repository;

import com.Assesment.Entity.ProductShelfItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductShelfItemRepository extends JpaRepository<ProductShelfItem, String> {
}