package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.gateways.client.FindClientByCpfGateway;
import com.br.fastBurguer.core.entities.Client;

public class FindClientByCpf {
    
    private final FindClientByCpfGateway findClientByCpfGateway;

    public FindClientByCpf(FindClientByCpfGateway findClientByCpfGateway) {
        this.findClientByCpfGateway = findClientByCpfGateway;
    }

    public Client findClientByCpf(String number) {
        return findClientByCpfGateway.findClientByCpf(number);
    }
}
