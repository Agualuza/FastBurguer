package com.br.fastBurguer.domain.client.Enums;

import lombok.Getter;

@Getter
public enum ClientIdentifyByEnum {
    
    NAME("name"),
    CPF("cpf"),
    NOTIDENTIFY("notidentify");

    private String value;

    ClientIdentifyByEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
