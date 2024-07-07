package com.panelaquente.panelaquente.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
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
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;   

    @Enumerated(EnumType.STRING)
    private Category category; 

}
