package com.br.fastBurguer.adapters.presenters.product;

import java.math.BigDecimal;

public record EditProductResponse(
        Long id,
        String name,
        String description,
        BigDecimal price,
        String type) {

}
