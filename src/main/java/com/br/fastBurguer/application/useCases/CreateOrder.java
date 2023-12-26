package com.br.fastBurguer.application.useCases;

import java.util.List;

import com.br.fastBurguer.application.gateways.CreateOrderGateway;
import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.core.entities.Order;

public class CreateOrder {

    private final CreateOrderGateway createOrderGateway;
    private final FindClientById findClientById;

    public CreateOrder(CreateOrderGateway createOrderGateway, FindClientById findClientById) {
        this.createOrderGateway = createOrderGateway;
        this.findClientById = findClientById;
    }

    public Order createOrder(Long clientId, List<String> products) {

        Client clientFound = findClientById.findClientById(clientId);

        if (clientFound == null) {
            throw new Error("Usuário não existe");
        }

        return createOrderGateway.createOrder(clientFound.getId(), products);
    }
}
