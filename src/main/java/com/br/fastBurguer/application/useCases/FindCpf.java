package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.gateways.cpf.FindCpfGateway;
import com.br.fastBurguer.core.entities.Cpf;

public class FindCpf {

    private FindCpfGateway findClientByCpfGateway;

    public FindCpf(FindCpfGateway findClientByCpfGateway) {
        this.findClientByCpfGateway = findClientByCpfGateway;
    }

    public Cpf findClientByCpf(String number) {
        return findClientByCpfGateway.findCpf(number);
    }

}
