package com.br.fastBurguer.utils;

import org.springframework.stereotype.Service;

@Service
public class ConvertCpfParam {
    
    public String validateCpfParams(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            throw new NullPointerException("CPF inválido.");
        }

        return cpf.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }
}
