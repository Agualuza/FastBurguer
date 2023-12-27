package com.br.fastBurguer.core.entities;

public class Queue {

    public Queue(Long orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public Queue(Long id, Long orderId, String status) {
        this.id = id;
        this.orderId = orderId;
        this.status = status;
    }

    private Long id;
    private Long orderId;
    String status;

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

}
