package com.br.fastBurguer.infra.persistence.order;

import java.util.List;
import java.util.Optional;

import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.infra.persistence.client.ClientEntity;

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

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    public OrderEntity(@NotNull ClientEntity clientEntity, @NotNull List<String> products) {
        this.clientEntity = clientEntity;
        this.products = products;
    }

    public OrderEntity(Optional<Client> clientOptional, List<String> products) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clients_id")
    private ClientEntity clientEntity;

    @NotNull
    List<String> products;
}
