package com.br.fastBurguer.core.entities;

import java.util.List;
import java.util.Optional;

public class Order {

    public Order(Long clientId, List<Long> products) {
        this.clientId = clientId;
        this.products = products;
    }

    public Order(Long id, Long clientId, List<Long> products) {
        this.id = id;
        this.clientId = clientId;
        this.products = products;
    }

    public Order(Long id, Long clientId, List<Long> products, boolean paymentApproved) {
        this.id = id;
        this.clientId = clientId;
        this.products = products;
        this.paymentApproved = paymentApproved;
    }

    public Order(Optional<Client> clientOptional, List<Long> products) {
    }

    private Long id;
    private Long clientId;
    private List<Long> products;
    private boolean paymentApproved = false;

    public Long getId() {
        return id;
    }

    public Long getClientId() {
        return clientId;
    }

    public List<Long> getProducts() {
        return products;
    }

    public boolean isPaymentApproved() {
        return paymentApproved;
    }

    public void setPaymentApproved(boolean paymentApproved) {
        this.paymentApproved = paymentApproved;
    }

}
