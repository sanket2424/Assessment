package com.Assesment.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_metadata")
public class ProductMetadata {
    @Id
    @Column(name = "product_id")
    private String productId;

    private String category;
    private String brand;
}