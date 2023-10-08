package com.br.fastBurguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fastBurguer.domain.combo.Combo;

@Repository
public interface ComboRepository extends JpaRepository<Combo, Long> {
    
}
