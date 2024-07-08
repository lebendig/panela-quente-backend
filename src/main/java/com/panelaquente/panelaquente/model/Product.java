package com.panelaquente.panelaquente.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.panelaquente.panelaquente.converter.CategoryConverter;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class Product {

    public enum Category {
        FOOD("food"), DRINK("drink");

        private final String value;

        Category(String value){
            this.value = value;
        }

        public String getValue(){
            return value;
        }

        @JsonCreator
        public static Category fromString(String key) {
            return key == null ? null : Category.valueOf(key.toUpperCase());
        }

        @JsonValue
        public String toValue() {
            return name().toLowerCase();
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;   

    @Convert(converter = CategoryConverter.class)
    private Category category; 

}
