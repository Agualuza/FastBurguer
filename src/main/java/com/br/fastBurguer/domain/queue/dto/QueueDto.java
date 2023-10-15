package com.br.fastBurguer.domain.queue.dto;

import jakarta.validation.constraints.NotNull;

public record QueueDto(
    @NotNull Long id
) {
    
}
