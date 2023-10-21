package com.br.fastBurguer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fastBurguer.domain.cpf.CPF;

@Repository
public interface CpfRepository extends JpaRepository<CPF, Long> {
    public CPF findByNumber(String number);
}
