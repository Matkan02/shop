package com.matkan.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Item {

    @Id
    @GeneratedValue

    private long id;
    private String name;
    private BigDecimal price;
    private String img;

    public Item(String name, BigDecimal price, String img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }
}


