package com.panelaquente.panelaquente.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panelaquente.dto.ProductDTO;
import com.panelaquente.dto.ProductDTOImp;
import com.panelaquente.panelaquente.model.Product;
import com.panelaquente.panelaquente.model.Product.Category;
import com.panelaquente.panelaquente.repository.ProductRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @PostMapping("/products/new")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTOImp product) {
        //Product savedProduct = productService.saveProduct(product);
        ProductDTO savedProduct = null;
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

}
