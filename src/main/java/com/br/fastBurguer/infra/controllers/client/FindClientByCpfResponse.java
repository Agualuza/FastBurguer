package com.br.fastBurguer.infra.controllers.client;

import com.br.fastBurguer.core.entities.Cpf;
import com.br.fastBurguer.core.entities.Email;

public record FindClientByCpfResponse(
        Long id,
        String name,
        Cpf cpf,
        Email email,
        String identify) {

}
