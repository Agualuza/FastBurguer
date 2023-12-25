package com.br.fastBurguer.infra.persistence.cpf;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpfRepository extends JpaRepository<CpfEntity, Long> {
    public Optional<CpfEntity> findByNumber(String number);
}
