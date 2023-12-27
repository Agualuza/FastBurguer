package com.br.fastBurguer.adapters.presenters.client;

import com.br.fastBurguer.core.entities.Client;

public class ClientDTOMapper {

    public FindClientByCpfResponse toResponse(Client client) {
        return new FindClientByCpfResponse(client.getId(), client.getName(), client.getCpf(), client.getEmail(), client.getIdentified());
    }

    public Client toClient(CreateClientRequest createClientRequest) {
        return new Client(createClientRequest.name(), createClientRequest.cpf(), createClientRequest.email(), createClientRequest.identified().getValue());
    }
}
