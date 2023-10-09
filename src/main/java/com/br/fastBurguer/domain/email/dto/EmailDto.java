package com.br.fastBurguer.domain.email.dto;

import jakarta.validation.constraints.Pattern;

public record EmailDto(
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$") String address
) {
    
}
