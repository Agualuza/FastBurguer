package com.br.fastBurguer.infra.persistence.order;

import java.util.List;
import java.util.Optional;

import com.br.fastBurguer.core.entities.Client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    public OrderEntity(@NotNull Long clientId, @NotNull List<String> products) {
        this.clientId = clientId;
        this.products = products;
    }

    public OrderEntity(Optional<Client> clientOptional, List<String> products) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long clientId;

    @NotNull
    List<String> products;
}
