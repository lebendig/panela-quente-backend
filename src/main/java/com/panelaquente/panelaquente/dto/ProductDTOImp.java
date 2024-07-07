package com.panelaquente.panelaquente.dto;


import com.panelaquente.panelaquente.model.Product.Category;

public class ProductDTOImp implements ProductDTO  {

    private Long id;
    private String name;   
    private Category category;

    public ProductDTOImp() {
    }

    public ProductDTOImp(Long id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

    


    


    


