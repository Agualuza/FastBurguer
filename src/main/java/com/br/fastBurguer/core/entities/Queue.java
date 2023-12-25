package com.br.fastBurguer.core.entities;

public class Queue {

    public Queue(Order order, String status) {
        this.order = order;
        this.status = status;
    }

    public Queue(Long id, Order order, String status) {
        this.id = id;
        this.order = order;
        this.status = status;
    }

    private Long id;
    private Order order;
    String status;

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public String getStatus() {
        return status;
    }

}
