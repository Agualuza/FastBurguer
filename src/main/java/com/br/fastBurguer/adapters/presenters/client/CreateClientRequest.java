package com.br.fastBurguer.adapters.presenters.client;

import com.br.fastBurguer.core.Enums.ClientIdentifyByEnum;

import jakarta.validation.constraints.NotNull;

public record CreateClientRequest(
        @NotNull String name,
        String cpfNumber,
        String emailAddress,
        @NotNull ClientIdentifyByEnum identified) {

}
