package com.br.fastBurguer.core.entities;

import java.util.List;
import java.util.Optional;

public class Order {

    public Order(Long clientId, List<String> products) {
        this.clientId = clientId;
        this.products = products;
    }

    public Order(Long id, Long clientId, List<String> products) {
        this.id = id;
        this.clientId = clientId;
        this.products = products;
    }

    public Order(Optional<Client> clientOptional, List<String> products) {
    }

    private Long id;
    private Long clientId;
    private List<String> products;

    public Long getId() {
        return id;
    }

    public Long getClientId() {
        return clientId;
    }

    public List<String> getProducts() {
        return products;
    }

}
