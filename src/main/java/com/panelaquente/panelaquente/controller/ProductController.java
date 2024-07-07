package com.panelaquente.panelaquente.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panelaquente.panelaquente.dto.ProductDTO;
import com.panelaquente.panelaquente.dto.ProductDTOImp;
import com.panelaquente.panelaquente.model.Product;
import com.panelaquente.panelaquente.model.Product.Category;
import com.panelaquente.panelaquente.repository.ProductRepository;
import com.panelaquente.panelaquente.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @GetMapping("/categories")
    public ResponseEntity<List<String>> getAllCategories() {
        List<String> categories = productService.getAllCategories(); 
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/products/new")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTOImp product) {
        productService.saveProduct(product);
        
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

}
