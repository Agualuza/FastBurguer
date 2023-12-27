package com.br.fastBurguer.infra.persistence.queue;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public QueueEntity(Long orderId, @NotNull String status) {
        this.orderId = orderId;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    @NotNull
    String status;
}
