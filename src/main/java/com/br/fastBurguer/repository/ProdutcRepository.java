package com.br.fastBurguer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fastBurguer.domain.products.Product;

@Repository
public interface ProdutcRepository extends JpaRepository<Product, Long> {
    public List<Product> findByType(String type);
}
