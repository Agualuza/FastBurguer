package com.br.fastBurguer.core.entities;

public class Client {

    public Client() {
    }

    public Client(String name, Cpf cpf, Email email, String identified) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.identified = identified;
    }

    public Client(Long id, String name, Cpf cpf, Email email, String identified) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.identified = identified;
    }

    private Long id;
    private String name;
    private Cpf cpf;
    private Email email;
    private String identified;
    private Long acessNum;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public Email getEmail() {
        return email;
    }

    public String getIdentified() {
        return identified;
    }

    public Long getAcessNum() {
        return acessNum;
    }

}