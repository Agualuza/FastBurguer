package com.br.fastBurguer.application.gateways;

import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.core.entities.Order;

public interface CreateOrderGateway {
    
    public Order createOrder(Client client, Order order); 
}
