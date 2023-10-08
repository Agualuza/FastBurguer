package com.br.fastBurguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fastBurguer.domain.products.drink.Drink;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
    
}
