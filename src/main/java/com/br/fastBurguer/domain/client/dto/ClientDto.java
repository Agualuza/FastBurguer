package com.br.fastBurguer.domain.client.dto;

import com.br.fastBurguer.domain.client.Enums.ClientIdentifyByEnum;
import com.br.fastBurguer.domain.cpf.dto.CpfDto;
import com.br.fastBurguer.domain.email.dto.EmailDto;

import jakarta.validation.constraints.NotNull;

public record ClientDto(
    @NotNull String name,
    CpfDto cpf,
    EmailDto email,
    @NotNull ClientIdentifyByEnum identified
) {
    
}
