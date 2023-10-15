package com.br.fastBurguer.domain.queue;

import com.br.fastBurguer.domain.order.Order;
import com.br.fastBurguer.domain.queue.Enums.StatusEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Queues")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Queue {

    public Queue(Order order, @NotNull StatusEnum status) {
        this.order = order;
        this.status = status;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Order order;

    @NotNull
    StatusEnum status;

}
