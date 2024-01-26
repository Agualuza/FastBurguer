package com.br.fastBurguer.infra.gateways.client;

import java.util.Optional;

import com.br.fastBurguer.adapters.gateways.client.FindClientByIdGateway;
import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.infra.persistence.client.ClientEntity;
import com.br.fastBurguer.infra.persistence.client.ClientEntityMapper;
import com.br.fastBurguer.infra.persistence.client.ClientRepository;

public class FindClientByIdRepositoryGateway implements FindClientByIdGateway{

    private final ClientEntityMapper clientEntityMapper;
    private final ClientRepository clientRepository;

    public FindClientByIdRepositoryGateway(ClientEntityMapper clientEntityMapper, ClientRepository clientRepository) {
        this.clientEntityMapper = clientEntityMapper;
        this.clientRepository = clientRepository;
    }

    @Override
    public Client findClientById(Long id) {
        Optional<ClientEntity> clientFound = clientRepository.findById(id);
        return clientEntityMapper.toDomain(clientFound.get());
    }
    
}
