package com.br.fastBurguer.adapters.gateways.client;

import com.br.fastBurguer.core.entities.Client;

public interface FindClientByIdGateway {
    
    public Client findClientById(Long id); 
}
