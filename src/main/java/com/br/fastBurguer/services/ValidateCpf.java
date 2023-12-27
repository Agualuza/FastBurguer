package com.br.fastBurguer.services;

import com.br.fastBurguer.adapters.gateways.cpf.ValidateCpfGateway;

public class ValidateCpf implements ValidateCpfGateway {

    public String validateCpfParams(String cpf) {
        String cpfValidated = cpf.replaceAll("[-.]", "");

        if (cpfValidated.length() != 11) {
            throw new RuntimeException("CPF inválido.");
        }

        return cpfValidated;
    }
}
