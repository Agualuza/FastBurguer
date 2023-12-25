package com.br.fastBurguer.core.entities;

public class Cpf {

    public Cpf() {
    }

    public Cpf(String number) {
        this.number = number;
    }

    private Long id;
    private String number;

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }
}
