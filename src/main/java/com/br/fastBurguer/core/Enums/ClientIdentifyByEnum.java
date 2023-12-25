package com.br.fastBurguer.core.Enums;

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
