package com.br.fastBurguer.infra.persistence.products;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutcRepository extends JpaRepository<ProductEntity, Long> {
    public List<ProductEntity> findByType(String type);
}
