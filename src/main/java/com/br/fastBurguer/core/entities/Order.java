package com.br.fastBurguer.core.entities;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Order {

    public Order(Long clientId, List<Long> products) {
        this.clientId = clientId;
        this.products = products;
    }

    public Order(Long id, Long clientId, List<Long> products, Date createdAt) {
        this.id = id;
        this.clientId = clientId;
        this.products = products;
        this.createdAt = createdAt;
    }

    public Order(Long id, Long clientId, List<Long> products, boolean paymentApproved, Date createdAt) {
        this.id = id;
        this.clientId = clientId;
        this.products = products;
        this.paymentApproved = paymentApproved;
        this.createdAt = createdAt;
    }

    public Order(Optional<Client> clientOptional, List<Long> products) {
    }

    private Long id;
    private Long clientId;
    private List<Long> products;
    private boolean paymentApproved = false;
    private Date createdAt;

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

    public Date getCreatedAt() {
        return createdAt;
    }
}
