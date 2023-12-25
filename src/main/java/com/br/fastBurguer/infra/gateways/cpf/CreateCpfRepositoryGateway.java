package com.br.fastBurguer.infra.gateways.cpf;

import com.br.fastBurguer.application.gateways.CreateCpfGateway;
import com.br.fastBurguer.core.entities.Cpf;
import com.br.fastBurguer.infra.persistence.cpf.CpfEntity;
import com.br.fastBurguer.infra.persistence.cpf.CpfRepository;

public class CreateCpfRepositoryGateway implements CreateCpfGateway {

    private final CpfEntityMapper cpfEntityMapper;
    private final CpfRepository cpfRepository;

    public CreateCpfRepositoryGateway(CpfEntityMapper cpfEntityMapper, CpfRepository cpfRepository) {
        this.cpfEntityMapper = cpfEntityMapper;
        this.cpfRepository = cpfRepository;
    }

    @Override
    public Cpf createCpf(Cpf cpf) {
        CpfEntity cpfEntity = cpfEntityMapper.toEntity(cpf);
        CpfEntity savedObj = cpfRepository.save(cpfEntity);
        return cpfEntityMapper.toDomain(savedObj);
    }
    
}
