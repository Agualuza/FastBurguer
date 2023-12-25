package com.br.fastBurguer.core.entities;

import java.util.List;
import java.util.Optional;

public class Order {

    public Order(Client client, List<String> products) {
        this.client = client;
        this.products = products;
    }

    public Order(Optional<Client> clientOptional, List<String> products) {
    }

    private Client client;
    List<String> products;

    public Client getClient() {
        return client;
    }

    public List<String> getProducts() {
        return products;
    }
}
