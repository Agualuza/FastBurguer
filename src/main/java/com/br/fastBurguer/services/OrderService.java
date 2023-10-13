package com.br.fastBurguer.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fastBurguer.domain.client.Client;
import com.br.fastBurguer.domain.order.Order;
import com.br.fastBurguer.domain.order.dto.OrderDto;
import com.br.fastBurguer.repository.ClientRepository;
import com.br.fastBurguer.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepoistory;

    @Autowired
    ClientRepository clientRepository;

    public void createOrder(OrderDto order) {

        Optional<Client> client = clientRepository.findById(order.clientId());

        if (client != null) {
            List<Long> products = order.products();
            Order orderCreated = new Order(client.get(), products);
            orderRepoistory.save(orderCreated);
        }

    }

    public List<Order> listAllOrders() {
        List<Order> arrayOrders = orderRepoistory.findAll();

        List<Order> itemsToReturn = new ArrayList<>();

        for (Order order : arrayOrders) {
            Order orderToAdd = new Order(order.getId(), order.getClient(), order.getProdutcsIds());
            itemsToReturn.add(orderToAdd);                    
        }

        return itemsToReturn;
    }

}
