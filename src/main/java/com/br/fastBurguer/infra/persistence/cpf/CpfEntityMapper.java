package com.br.fastBurguer.infra.persistence.cpf;

import java.util.Optional;

import com.br.fastBurguer.core.entities.Cpf;

public class CpfEntityMapper {

    public CpfEntity toCpfEntity(Cpf cpf) {
        return new CpfEntity(cpf.getNumber());
    }

    public Cpf toCpfDomain(CpfEntity cpfEntity) {
        return new Cpf(cpfEntity.getId(), cpfEntity.getNumber());
    }

    public Cpf toCpfDomain(Optional<CpfEntity> cpfEntity) {
        Cpf cpf;

        if (cpfEntity.isPresent()) {
            cpf = new Cpf(cpfEntity.get().getNumber());
        } else {
            cpf = new Cpf();
        }

        return cpf;
    }

}