package com.br.fastBurguer.infra.persistence.products;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor
public class ProductEntity {

    public ProductEntity(Long id, @NotNull String name, @NotNull String description, @NotNull BigDecimal price,
            @NotNull String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    public ProductEntity(@NotNull String name, @NotNull String description, @NotNull BigDecimal price,
            @NotNull String type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private BigDecimal price = BigDecimal.ZERO;

    @NotNull
    private String type;

}
