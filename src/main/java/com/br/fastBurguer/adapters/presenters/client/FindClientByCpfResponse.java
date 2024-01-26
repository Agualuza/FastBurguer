package com.br.fastBurguer.adapters.presenters.client;

public record FindClientByCpfResponse(
        Long id,
        String name,
        String cpfNumber,
        String emailAddress,
        String identify) {

}
