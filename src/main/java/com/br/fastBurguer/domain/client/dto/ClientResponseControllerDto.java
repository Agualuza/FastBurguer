package com.br.fastBurguer.domain.client.dto;

public record ClientResponseControllerDto(
    Long id,
    String cpf,
    String email,
    String identify
) {
    
}
