package com.br.fastBurguer.core.entities;

import java.math.BigDecimal;

public class Product {

    public Product(Long id, String name, String description, BigDecimal price,
            String type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    public Product(String name, String description, BigDecimal price, String type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    private Long id;
    private String name;
    private String description;
    private BigDecimal price = BigDecimal.ZERO;
    private String type;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
