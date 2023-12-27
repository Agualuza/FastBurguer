package com.br.fastBurguer.adapters.presenters.client;

import com.br.fastBurguer.core.entities.Cpf;
import com.br.fastBurguer.core.entities.Email;

public record FindClientByCpfResponse(
        Long id,
        String name,
        Cpf cpf,
        Email email,
        String identify) {

}
