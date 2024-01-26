package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.boundary.FindClientByCpfBoundary;
import com.br.fastBurguer.adapters.gateways.client.FindClientByCpfGateway;
import com.br.fastBurguer.adapters.presenters.client.ClientDTOMapper;
import com.br.fastBurguer.adapters.presenters.client.FindClientByCpfResponse;
import com.br.fastBurguer.core.entities.Client;

public class FindClientByCpf implements FindClientByCpfBoundary {
    
    private final FindClientByCpfGateway findClientByCpfGateway;
    private final ClientDTOMapper clientDTOMapper;

    public FindClientByCpf(FindClientByCpfGateway findClientByCpfGateway, ClientDTOMapper clientDTOMapper) {
        this.findClientByCpfGateway = findClientByCpfGateway;
        this.clientDTOMapper = clientDTOMapper;
    }

    @Override
    public FindClientByCpfResponse findClientByCpf(String number) {
        Client clientFound = findClientByCpfGateway.findClientByCpf(number);

        if (clientFound == null) {
            throw new RuntimeException("Client Not Found");
        }

        return clientDTOMapper.toResponse(clientFound);
    }
}
