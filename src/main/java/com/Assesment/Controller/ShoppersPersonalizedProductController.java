package com.Assesment.Controller;


import com.Assesment.Entity.ShoppersPersonalizedProduct;
import com.Assesment.Service.ShoppersPersonalizedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personalized-products")
public class ShoppersPersonalizedProductController {
    @Autowired
    private ShoppersPersonalizedProductService service;

    @PostMapping
    public void saveShoppersPersonalizedProduct(@RequestBody ShoppersPersonalizedProduct personalizedProduct) {
        service.saveShoppersPersonalizedProduct(personalizedProduct);
    }

    @GetMapping("/{shopperId}")
    public ShoppersPersonalizedProduct getShoppersPersonalizedProduct(@PathVariable String shopperId) {
        return service.getShoppersPersonalizedProduct(shopperId);
    }
}