package com.br.fastBurguer.domain.queue.Enums;

public enum StatusEnum {

    RECEIVE("Recebido"),
    DOING("Em preparação"),
    READY("PRONTO"),
    DONE("Finalizado");

    private String value;

    StatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static StatusEnum fromString(String text) {
        for (StatusEnum value : StatusEnum.values()) {
            if (value.value.equals(text)) {
                return value;
            }
        }
        return null; // Valor não reconhecido
    }
}
