package com.br.fastBurguer.servicesDto;

import jakarta.validation.constraints.Pattern;

public record EmailDto(
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$") String address
) {
    
}
