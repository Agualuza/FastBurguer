package com.br.fastBurguer.infra.persistence.queue;

import com.br.fastBurguer.infra.persistence.order.OrderEntity;

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
public class QueueEntity {

    public QueueEntity(OrderEntity orderEntity, @NotNull String status) {
        this.orderEntity = orderEntity;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private OrderEntity orderEntity;

    @NotNull
    String status;
}
