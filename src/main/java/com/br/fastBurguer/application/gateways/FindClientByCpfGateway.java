package com.br.fastBurguer.application.gateways;

import com.br.fastBurguer.core.entities.Client;

public interface FindClientByCpfGateway {
    
    public Client findClientByCpf(String number);
}
