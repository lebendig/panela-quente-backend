package com.panelaquente.panelaquente.Factory;

import org.springframework.stereotype.Component;

import com.panelaquente.panelaquente.dto.ProductDTO;
import com.panelaquente.panelaquente.dto.ProductDTOImp;
import com.panelaquente.panelaquente.model.Product;

@Component
public class ProductFactory implements DtoFactory<Product, ProductDTO>{

    @Override
    public Product createEntityFrom(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setCategory(dto.getCategory());
        return product;
    }

    @Override
    public ProductDTO createDTOFrom(Product product) {
        ProductDTOImp dto = new ProductDTOImp();
        dto.setName(product.getName());
        dto.setCategory(product.getCategory());
        return dto;
    }

}
