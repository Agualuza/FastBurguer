package com.br.fastBurguer.domain.combo;

import java.math.BigDecimal;

import com.br.fastBurguer.domain.products.drink.Drink;
import com.br.fastBurguer.domain.products.sandwich.Sandwich;
import com.br.fastBurguer.domain.products.sidedish.SideDish;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "combos")
public class Combo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne
    @Embedded
    @JoinColumn(name = "drinks_id")
    private Drink drink;

    @NotNull 
    @OneToOne
    @Embedded
    @JoinColumn(name = "sandwiches_id")
    private Sandwich sandwich;

    @NotNull
    @OneToOne
    @Embedded
    @JoinColumn(name = "sidedishes_id")
    private SideDish sidedish;

    @NotNull
    private BigDecimal price;

    public BigDecimal getTotalPrice(Drink drink, Sandwich sandwich, SideDish sidedish) {
        return drink.getPrice().add(sandwich.getPrice().add(sidedish.getPrice()));
    }

}
