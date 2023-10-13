package com.br.fastBurguer.domain.order;

import java.util.List;
import java.util.Optional;

import com.br.fastBurguer.domain.client.Client;

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
public class Order {

    public Order(@NotNull Client client, @NotNull List<Long> produtcsIds) {
        this.client = client;
        this.produtcsIds = produtcsIds;
    }

    public Order(Optional<Client> client2, List<Long> products) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Client client;

    @NotNull
    List<Long> produtcsIds;
}
