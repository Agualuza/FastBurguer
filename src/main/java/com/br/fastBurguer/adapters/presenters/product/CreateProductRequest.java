package com.br.fastBurguer.adapters.presenters.product;

import java.math.BigDecimal;

import com.br.fastBurguer.core.Enums.ProductEnum;

public record CreateProductRequest(
        String name,
        String description,
        BigDecimal price,
        ProductEnum type) {

}
