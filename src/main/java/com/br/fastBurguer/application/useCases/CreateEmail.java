package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.gateways.email.ValidateEmailGateway;
import com.br.fastBurguer.core.Enums.ClientIdentifyByEnum;
import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.core.entities.Email;

public class CreateEmail {

    private final ValidateEmailGateway validateEmailGateway;

    public CreateEmail(ValidateEmailGateway validateEmailGateway) {
        this.validateEmailGateway = validateEmailGateway;
    }

    public Email createClientEmail(Client client) {

        String emailAdress = client.getEmail().getAddress();
        Email emailToCreate;

        if (client.getIdentified().equals(ClientIdentifyByEnum.NAME.getValue())) {
            if (!validateEmailGateway.isEmailValid(emailAdress)) {
                throw new RuntimeException("Email inválido");
            } else {
                emailToCreate = new Email(emailAdress);
            }

        } else {
            emailToCreate = new Email(null);
        }

        return emailToCreate;
    }

}
