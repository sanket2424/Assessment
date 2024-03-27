package com.Assesment.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_shelf_item")
public class ProductShelfItem {
    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "relevancy_score")
    private double relevancyScore;
}