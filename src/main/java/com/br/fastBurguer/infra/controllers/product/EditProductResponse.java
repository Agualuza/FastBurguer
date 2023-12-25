package com.br.fastBurguer.infra.controllers.product;

import java.math.BigDecimal;

public record EditProductResponse(
        Long id,
        String name,
        String description,
        BigDecimal price,
        String type) {

}
