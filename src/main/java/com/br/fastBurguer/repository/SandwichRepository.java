package com.br.fastBurguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fastBurguer.domain.products.sandwich.Sandwich;

@Repository
public interface SandwichRepository extends JpaRepository<Sandwich, Long> {
    
}
