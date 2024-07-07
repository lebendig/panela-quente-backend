package com.panelaquente.panelaquente.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panelaquente.panelaquente.Factory.ProductFactory;
import com.panelaquente.panelaquente.dto.ProductDTO;
import com.panelaquente.panelaquente.model.Product;
import com.panelaquente.panelaquente.model.Product.Category;
import com.panelaquente.panelaquente.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductFactory productFactory;

    public Product saveProduct(ProductDTO productDTO) {
        Product product = productFactory.createEntityFrom(productDTO);
        return productRepository.save(product);
    }

    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                                .stream()
                                .map(productFactory::createDTOFrom)
                                .toList();
    }

    public List<String> getAllCategories() {
        return Arrays.stream(Category.values())
                    .map(Category::getValue)
                    .collect(Collectors.toList());
    }
}
