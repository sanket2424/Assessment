package com.Assesment.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shoppers_personalized_product")
public class ShoppersPersonalizedProduct {
    @Id
    @Column(name = "shopper_id")
    @NotBlank(message = "Shopper ID is required")
    private String shopperId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "shopper_id", referencedColumnName = "shopper_id")
    @NotEmpty(message = "Shopper's personalized product list cannot be empty")
    private List<ProductShelfItem> shelf;
}