package com.br.fastBurguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fastBurguer.domain.order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
