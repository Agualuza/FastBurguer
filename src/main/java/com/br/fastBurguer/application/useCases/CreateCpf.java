package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.application.gateways.CreateCpfGateway;
import com.br.fastBurguer.core.Enums.ClientIdentifyByEnum;
import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.core.entities.Cpf;
import com.br.fastBurguer.utils.ValidateCpf;

public class CreateCpf {

    private final CreateCpfGateway createCpfGateway;
    private final FindCpf findCpf;

    public CreateCpf(CreateCpfGateway createCpfGateway, FindCpf findCpf) {
        this.createCpfGateway = createCpfGateway;
        this.findCpf = findCpf;
    }

    public Cpf createCpf(Client client, Cpf cpf) {

        Cpf cpfToCreate;

        Cpf cpfAlreadyExists = findCpf.findClientByCpf(ValidateCpf.validateCpfParams(client.getCpf().getNumber()));

        if (cpfAlreadyExists.getNumber() != null) {
            throw new RuntimeException("Cpf já cadastrado");
        }

        if (client.getIdentified().equals(ClientIdentifyByEnum.NOTIDENTIFY.getValue())
                || (client.getIdentified().equals(ClientIdentifyByEnum.NAME.getValue()))) {
            cpfToCreate = new Cpf(null);
        } else {
            cpfToCreate = new Cpf(client.getCpf().getNumber());
        }

        return createCpfGateway.createCpf(cpfToCreate);
    }

}
