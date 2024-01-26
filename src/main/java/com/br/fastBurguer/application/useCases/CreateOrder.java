package com.br.fastBurguer.application.useCases;

import com.br.fastBurguer.adapters.boundary.CreateOrderBoundary;
import com.br.fastBurguer.adapters.gateways.order.CreateOrderGateway;
import com.br.fastBurguer.adapters.presenters.order.CreateOrderRequest;
import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.core.entities.Order;

public class CreateOrder implements CreateOrderBoundary {

    private final CreateOrderGateway createOrderGateway;
    private final FindClientById findClientById;
    private final CreateQueue createQueue;

    public CreateOrder(CreateOrderGateway createOrderGateway, FindClientById findClientById, CreateQueue createQueue) {
        this.createOrderGateway = createOrderGateway;
        this.findClientById = findClientById;
        this.createQueue = createQueue;
    }

    @Override
    public void createOrder(CreateOrderRequest createOrderRequest) {

        Client clientFound = findClientById.findClientById(createOrderRequest.clientId());

        if (clientFound == null) {
            throw new Error("Usuário não existe");
        }

        Order orderToCreate = new Order(clientFound.getId(), createOrderRequest.products());

        Order orderCreated = createOrderGateway.createOrder(orderToCreate);

        createQueue.createQueue(orderCreated.getId());
    }
}
