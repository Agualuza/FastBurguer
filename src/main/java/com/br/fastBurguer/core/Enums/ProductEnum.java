package com.br.fastBurguer.core.Enums;

public enum ProductEnum {
    DRINK("bebida"),
    SIDEDISH("acompanhamento"),
    SANDWICH("lanche");

    private String type;

    ProductEnum(String type) {
        this.type = type;
    }

    public String getValue() {
        return type;
    }

    public static ProductEnum fromString(String text) {
        for (ProductEnum value : ProductEnum.values()) {
            if (value.type.equals(text)) {
                return value;
            }
        }
        return null; // Valor não reconhecido
    }
}
