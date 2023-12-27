package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.gateways.client.FindClientByIdGateway;
import com.br.fastBurguer.core.entities.Client;

public class FindClientById {

    private final FindClientByIdGateway findClientByIdGateway;

    public FindClientById(FindClientByIdGateway findClientByIdGateway) {
        this.findClientByIdGateway = findClientByIdGateway;
    }

    public Client findClientById(Long id) {
        return findClientByIdGateway.findClientById(id);
    }
}
