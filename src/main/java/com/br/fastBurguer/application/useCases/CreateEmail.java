package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.core.entities.Email;

public class CreateEmail {

    public Email createClientEmail(Client client, Email email) {
        Email emailToCreate = new Email(client.getEmail().getAddress());

        return emailToCreate;
    }

}
