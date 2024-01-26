package com.br.fastBurguer.adapters.presenters.client;

import com.br.fastBurguer.core.entities.Client;

public class ClientDTOMapper {

    public FindClientByCpfResponse toResponse(Client client) {
        return new FindClientByCpfResponse(client.getId(), client.getName(), client.getCpf().getNumber(), client.getEmail().getAddress(), client.getIdentified());
    }
}
