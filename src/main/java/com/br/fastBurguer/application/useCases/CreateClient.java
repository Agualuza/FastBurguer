package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.application.gateways.CreateClientGateway;
import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.core.entities.Cpf;
import com.br.fastBurguer.core.entities.Email;

public class CreateClient {

    private final CreateClientGateway createClientGateway;
    private final CreateCpf createCpf;
    private final CreateEmail createEmail;

    public CreateClient(CreateClientGateway createClientGateway, CreateCpf createCpf, CreateEmail createEmail) {
        this.createClientGateway = createClientGateway;
        this.createCpf = createCpf;
        this.createEmail = createEmail;
    }

    public Client createClient(Client client) {

        Cpf cpf = createCpf.createCpf(client, client.getCpf());

        Email email = createEmail.createClientEmail(client, client.getEmail());

        Client clientToPersist = new Client(client.getName(), cpf, email, client.getIdentified());

        return createClientGateway.createClient(clientToPersist);
    }
}
