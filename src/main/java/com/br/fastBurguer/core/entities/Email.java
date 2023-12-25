package com.br.fastBurguer.core.entities;

public class Email {

    public Email() {
    }

    public Email(String address) {
        this.address = address;
    }

    private Long id;
    private String address;

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

}
