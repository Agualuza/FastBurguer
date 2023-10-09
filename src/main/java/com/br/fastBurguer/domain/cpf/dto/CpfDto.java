package com.br.fastBurguer.domain.cpf.dto;

import jakarta.validation.constraints.Pattern;

public record CpfDto(
    @Pattern(regexp = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11})$") String number
) {
    
}
