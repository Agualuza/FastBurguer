package com.br.fastBurguer.domain.order.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;

public record OrderDto(
    @NotNull Long clientId,
    @NotNull List<Long> products
) {
    
}
