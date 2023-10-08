package com.br.fastBurguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fastBurguer.domain.products.sidedish.SideDish;

@Repository
public interface SideWishRepository extends JpaRepository<SideDish, Long> {
    
}
