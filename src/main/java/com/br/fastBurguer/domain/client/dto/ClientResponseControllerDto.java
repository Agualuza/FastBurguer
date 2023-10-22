package com.br.fastBurguer.domain.client.dto;

public record ClientResponseControllerDto(
    Long id,
    String name,
    String cpf,
    String email,
    String identify
) {
    
}
