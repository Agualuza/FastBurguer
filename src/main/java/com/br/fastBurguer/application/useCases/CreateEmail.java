package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.boundary.CreateEmailBoundary;
import com.br.fastBurguer.adapters.gateways.email.ValidateEmailGateway;
import com.br.fastBurguer.adapters.presenters.client.CreateClientRequest;
import com.br.fastBurguer.core.Enums.ClientIdentifyByEnum;
import com.br.fastBurguer.core.entities.Email;

public class CreateEmail implements CreateEmailBoundary {

    private final ValidateEmailGateway validateEmailGateway;

    public CreateEmail(ValidateEmailGateway validateEmailGateway) {
        this.validateEmailGateway = validateEmailGateway;
    }

    @Override
    public Email createClientEmail(CreateClientRequest createClientRequest) {

        String emailAdress = createClientRequest.emailAddress();
        Email emailToCreate;

        if (createClientRequest.identified().getValue().equals(ClientIdentifyByEnum.NAME.getValue())) {
            if (!validateEmailGateway.isEmailValid(emailAdress)) {
                throw new RuntimeException("Email inválido");
            } else {
                emailToCreate = new Email(emailAdress);
            }

        } else {
            emailToCreate = new Email("Sem cadastro");
        }

        return emailToCreate;
    }

}
