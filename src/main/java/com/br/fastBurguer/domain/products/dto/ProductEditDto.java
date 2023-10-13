package com.br.fastBurguer.domain.products.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public record ProductEditDto(
    @NotNull Long id,
    @NotNull String name,
    @NotNull String description,
    @NotNull BigDecimal price,
    @NotNull String type
) {
    
}
