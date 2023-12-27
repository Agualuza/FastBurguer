package com.br.fastBurguer.infra.gateways.client;

import com.br.fastBurguer.adapters.gateways.client.CreateClientGateway;
import com.br.fastBurguer.adapters.presenters.client.ClientEntityMapper;
import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.infra.persistence.client.ClientEntity;
import com.br.fastBurguer.infra.persistence.client.ClientRepository;

public class CreateClientRepositoryGateway implements CreateClientGateway  {

    private final ClientRepository clientRepository;
    private final ClientEntityMapper clientEntityMapper;

    public CreateClientRepositoryGateway(ClientRepository clientRepository, ClientEntityMapper clientEntityMapper) {
        this.clientRepository = clientRepository;
        this.clientEntityMapper = clientEntityMapper;
    }

    @Override
    public Client createClient(Client client) {
        ClientEntity clientEntity = clientEntityMapper.toEntity(client);
        ClientEntity savedObj = clientRepository.save(clientEntity);
        return clientEntityMapper.toDomain(savedObj);
    }
    
}
