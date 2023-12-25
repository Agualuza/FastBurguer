package com.br.fastBurguer.infra.gateways.cpf;

import java.util.Optional;

import com.br.fastBurguer.application.gateways.FindCpfGateway;
import com.br.fastBurguer.core.entities.Cpf;
import com.br.fastBurguer.infra.persistence.cpf.CpfEntity;
import com.br.fastBurguer.infra.persistence.cpf.CpfRepository;

public class SearchCpfRepositoryGateway implements FindCpfGateway {
    
    private final CpfEntityMapper cpfEntityMapper;
    private final CpfRepository cpfRepository;

    public SearchCpfRepositoryGateway(CpfEntityMapper cpfEntityMapper, CpfRepository cpfRepository) {
        this.cpfEntityMapper = cpfEntityMapper;
        this.cpfRepository = cpfRepository;
    }

    @Override
    public Cpf findCpf(String number) {
        Optional<CpfEntity> cpfEntity = cpfRepository.findByNumber(number);
        return cpfEntityMapper.toDomain(cpfEntity);
    }

    
    
}
