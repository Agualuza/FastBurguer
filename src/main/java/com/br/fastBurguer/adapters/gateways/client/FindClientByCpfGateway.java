package com.br.fastBurguer.adapters.gateways.client;

import com.br.fastBurguer.core.entities.Client;

public interface FindClientByCpfGateway {
    
    public Client findClientByCpf(String number);
}
