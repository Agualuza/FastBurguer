package com.br.fastBurguer.infra.gateways.cpf;

import java.util.Optional;

import com.br.fastBurguer.core.entities.Cpf;
import com.br.fastBurguer.infra.persistence.cpf.CpfEntity;

public class CpfEntityMapper {

    public CpfEntity toEntity(Cpf cpfDomain) {
        return new CpfEntity(cpfDomain.getNumber());
    }

    public Cpf toDomain(CpfEntity cpfEntity) {
        return new Cpf(cpfEntity.getNumber());
    }

    public Cpf toDomain(Optional<CpfEntity> cpfEntity) {
        Cpf cpf;

        if(cpfEntity.isPresent()){
            cpf = new Cpf(cpfEntity.get().getNumber());
        } else {
            cpf = new Cpf();
        }

        return cpf;
    }
}
