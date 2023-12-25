package com.br.fastBurguer.infra.controllers.product;

import java.math.BigDecimal;

import com.br.fastBurguer.core.Enums.ProductEnum;

public record EditProductRequest(
        Long id,
        String name,
        String description,
        BigDecimal price,
        ProductEnum type) {

}
