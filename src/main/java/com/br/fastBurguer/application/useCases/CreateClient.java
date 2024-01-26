package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.boundary.CreateClientBoundary;
import com.br.fastBurguer.adapters.gateways.client.CreateClientGateway;
import com.br.fastBurguer.adapters.presenters.client.CreateClientRequest;
import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.core.entities.Cpf;
import com.br.fastBurguer.core.entities.Email;

public class CreateClient implements CreateClientBoundary {

    private final CreateClientGateway createClientGateway;
    private final CreateCpf createCpf;
    private final CreateEmail createEmail;

    public CreateClient(CreateClientGateway createClientGateway, CreateCpf createCpf, CreateEmail createEmail) {
        this.createClientGateway = createClientGateway;
        this.createCpf = createCpf;
        this.createEmail = createEmail;
    }

    @Override
    public void createClient(CreateClientRequest createClientRequest) {

        Cpf cpf = createCpf.createCpf(createClientRequest);

        Email email = createEmail.createClientEmail(createClientRequest);

        Client clientToPersist = new Client(createClientRequest.name(), cpf, email, createClientRequest.identified().getValue());

        createClientGateway.createClient(clientToPersist);
    }
}
