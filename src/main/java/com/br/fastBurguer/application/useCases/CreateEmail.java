package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.application.gateways.CreateEmailGateway;
import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.core.entities.Email;

public class CreateEmail {

    private final CreateEmailGateway createEmailGateway;

    public CreateEmail(CreateEmailGateway createEmailGateway) {
        this.createEmailGateway = createEmailGateway;
    }

    public Email createClientEmail(Client client, Email email) {
        Email emailToCreate = new Email(client.getEmail().getAddress());

        return createEmailGateway.createEmail(emailToCreate);
    }

}
