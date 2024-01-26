package com.br.fastBurguer.adapters.boundary;

import com.br.fastBurguer.adapters.presenters.client.CreateClientRequest;
import com.br.fastBurguer.core.entities.Cpf;

public interface CreateCpfBoundary {
    
    public Cpf createCpf(CreateClientRequest createClientRequest);
}
