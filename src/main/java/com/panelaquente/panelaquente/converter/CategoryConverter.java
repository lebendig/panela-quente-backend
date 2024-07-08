package com.panelaquente.panelaquente.converter;

import com.panelaquente.panelaquente.model.Product.Category;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category, String>{

    @Override
    public String convertToDatabaseColumn(Category category) {
        if (category == null) {
            return null;
        }

        return category.getValue();
        
    }

    @Override
    public Category convertToEntityAttribute(String category) {
        if (category == null) {
            return null;
        }

        return Stream.of(Category.values())
            .filter(c -> c.getValue().equals(category))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);      
    }

}
