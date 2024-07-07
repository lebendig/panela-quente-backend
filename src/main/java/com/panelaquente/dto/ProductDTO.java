package com.panelaquente.dto;

import com.panelaquente.panelaquente.model.Product.Category;


public interface ProductDTO {

    Long getId();

    String getName();

    Category getCategory();

}
