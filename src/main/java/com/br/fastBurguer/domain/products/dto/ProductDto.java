package com.br.fastBurguer.domain.products.dto;

import java.math.BigDecimal;

import com.br.fastBurguer.domain.products.enums.ProductEnum;

import jakarta.validation.constraints.NotNull;

public record ProductDto(
    @NotNull String name,
    @NotNull String description,
    @NotNull BigDecimal price,
    @NotNull ProductEnum type
) {
    
}
