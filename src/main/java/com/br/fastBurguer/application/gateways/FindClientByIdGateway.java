package com.br.fastBurguer.application.gateways;

import com.br.fastBurguer.core.entities.Client;

public interface FindClientByIdGateway {
    
    public Client findClientById(Long id); 
}
