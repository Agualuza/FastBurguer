package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.boundary.CreateCpfBoundary;
import com.br.fastBurguer.adapters.gateways.cpf.ValidateCpfGateway;
import com.br.fastBurguer.adapters.presenters.client.CreateClientRequest;
import com.br.fastBurguer.core.Enums.ClientIdentifyByEnum;
import com.br.fastBurguer.core.entities.Cpf;

public class CreateCpf implements CreateCpfBoundary {

    private final FindCpf findCpf;
    private final ValidateCpfGateway validateCpfGateway;

    public CreateCpf(FindCpf findCpf, ValidateCpfGateway validateCpfGateway) {
        this.findCpf = findCpf;
        this.validateCpfGateway = validateCpfGateway;
    }

    @Override
    public Cpf createCpf(CreateClientRequest createClientRequest) {

        Cpf cpfToCreate;

        if (createClientRequest.identified().getValue().equals(ClientIdentifyByEnum.NOTIDENTIFY.getValue())
                || (createClientRequest.identified().getValue().equals(ClientIdentifyByEnum.NAME.getValue()))) {
            cpfToCreate = new Cpf(null);
        } else {
            String cpfNumberValidated = validateCpfGateway.validateCpfParams(createClientRequest.cpfNumber());
            Cpf cpfAlreadyExists = findCpf.findClientByCpf(cpfNumberValidated);
            if (cpfAlreadyExists.getNumber() != null) {
                throw new RuntimeException("Cpf já cadastrado");
            }
            cpfToCreate = new Cpf(cpfNumberValidated);
        }

        return cpfToCreate;
    }

}
