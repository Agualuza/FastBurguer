package com.br.fastBurguer.domain.order;

import com.br.fastBurguer.domain.client.Client;
import com.br.fastBurguer.domain.combo.Combo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "combos_id")
    private Combo combo;

}
