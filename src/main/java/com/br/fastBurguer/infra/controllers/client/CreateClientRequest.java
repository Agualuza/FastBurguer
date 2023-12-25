package com.br.fastBurguer.infra.controllers.client;

import com.br.fastBurguer.core.Enums.ClientIdentifyByEnum;
import com.br.fastBurguer.core.entities.Cpf;
import com.br.fastBurguer.core.entities.Email;

import jakarta.validation.constraints.NotNull;

public record CreateClientRequest(
        @NotNull String name,
        Cpf cpf,
        Email email,
        @NotNull ClientIdentifyByEnum identified) {

}
