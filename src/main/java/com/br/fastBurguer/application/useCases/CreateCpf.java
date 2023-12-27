package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.ValidateCpfGateway;
import com.br.fastBurguer.core.Enums.ClientIdentifyByEnum;
import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.core.entities.Cpf;

public class CreateCpf {

    private final FindCpf findCpf;
    private final ValidateCpfGateway validateCpfGateway;

    public CreateCpf(FindCpf findCpf, ValidateCpfGateway validateCpfGateway) {
        this.findCpf = findCpf;
        this.validateCpfGateway = validateCpfGateway;
    }

    public Cpf createCpf(Client client) {

        Cpf cpfToCreate;

        if (client.getIdentified().equals(ClientIdentifyByEnum.NOTIDENTIFY.getValue())
                || (client.getIdentified().equals(ClientIdentifyByEnum.NAME.getValue()))) {
            cpfToCreate = new Cpf(null);
        } else {
            String cpfNumberValidated = validateCpfGateway.validateCpfParams(client.getCpf().getNumber());
            Cpf cpfAlreadyExists = findCpf.findClientByCpf(cpfNumberValidated);
            if (cpfAlreadyExists.getNumber() != null) {
                throw new RuntimeException("Cpf já cadastrado");
            }
            cpfToCreate = new Cpf(cpfNumberValidated);
        }

        return cpfToCreate;
    }

}
