package com.br.fastBurguer.domain.cpf.dto;

import jakarta.validation.constraints.Pattern;

public record CpfDto(
    @Pattern(regexp = "^(?:\\d{3}\\.){2}\\d{3}-\\d{2}$") String number
) {
    
}
