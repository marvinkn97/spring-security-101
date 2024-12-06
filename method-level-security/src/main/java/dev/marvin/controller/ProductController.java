package dev.marvin.controller;

import dev.marvin.domain.Product;
import dev.marvin.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/sell")
    public List<Product> sellProduct(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("beer", "marvin"));
        products.add(new Product("candy", "rita"));
        products.add(new Product("chocolate", "imma"));
        return productService.sellProducts(products);
    }
}
