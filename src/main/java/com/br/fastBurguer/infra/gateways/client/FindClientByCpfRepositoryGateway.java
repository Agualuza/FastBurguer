package com.br.fastBurguer.infra.gateways.client;

import com.br.fastBurguer.application.gateways.FindClientByCpfGateway;
import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.infra.persistence.client.ClientEntity;
import com.br.fastBurguer.infra.persistence.client.ClientRepository;

public class FindClientByCpfRepositoryGateway implements FindClientByCpfGateway {

    private final ClientEntityMapper clientEntityMapper;
    private final ClientRepository clientRepository;

    public FindClientByCpfRepositoryGateway(ClientEntityMapper clientEntityMapper, ClientRepository clientRepository) {
        this.clientEntityMapper = clientEntityMapper;
        this.clientRepository = clientRepository;
    }

    @Override
    public Client findClientByCpf(String number) {
        ClientEntity clientEntity = clientRepository.findClientCpf(number);
        return clientEntityMapper.toDomain(clientEntity);
    }
    
}
