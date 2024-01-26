package com.br.fastBurguer.adapters.boundary;

import com.br.fastBurguer.adapters.presenters.client.CreateClientRequest;
import com.br.fastBurguer.core.entities.Email;

public interface CreateEmailBoundary {
    
    public Email createClientEmail(CreateClientRequest createClientRequest);
}
