package com.br.fastBurguer.core.Enums;

public enum QueueStatusEnum {

    RECEIVE("Recebido"),
    DOING("Em preparação"),
    READY("PRONTO"),
    DONE("Finalizado");

    private String value;

    QueueStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static QueueStatusEnum fromString(String text) {
        for (QueueStatusEnum value : QueueStatusEnum.values()) {
            if (value.value.equals(text)) {
                return value;
            }
        }
        return null; // Valor não reconhecido
    }
}
