package com.br.fastBurguer.application.useCases;

import java.util.List;

import com.br.fastBurguer.adapters.gateways.order.CreateOrderGateway;
import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.core.entities.Order;

public class CreateOrder {

    private final CreateOrderGateway createOrderGateway;
    private final FindClientById findClientById;
    private final CreateQueue createQueue;

    public CreateOrder(CreateOrderGateway createOrderGateway, FindClientById findClientById, CreateQueue createQueue) {
        this.createOrderGateway = createOrderGateway;
        this.findClientById = findClientById;
        this.createQueue = createQueue;
    }

    public Order createOrder(Long clientId, List<Long> products) {

        Client clientFound = findClientById.findClientById(clientId);

        if (clientFound == null) {
            throw new Error("Usuário não existe");
        }

        Order orderCreated = createOrderGateway.createOrder(clientFound.getId(), products);

        createQueue.createQueue(orderCreated.getId());

        return orderCreated;
    }
}
