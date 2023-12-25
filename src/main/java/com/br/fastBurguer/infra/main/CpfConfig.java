package com.br.fastBurguer.infra.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fastBurguer.application.gateways.CreateCpfGateway;
import com.br.fastBurguer.application.gateways.FindCpfGateway;
import com.br.fastBurguer.application.useCases.CreateCpf;
import com.br.fastBurguer.application.useCases.FindCpf;
import com.br.fastBurguer.infra.gateways.cpf.CpfEntityMapper;
import com.br.fastBurguer.infra.gateways.cpf.CreateCpfRepositoryGateway;
import com.br.fastBurguer.infra.gateways.cpf.SearchCpfRepositoryGateway;
import com.br.fastBurguer.infra.persistence.cpf.CpfRepository;

@Configuration
public class CpfConfig {

    @Bean
    CreateCpf createCpf(CreateCpfGateway createCpfGateway, FindCpf findCpf) {
        return new CreateCpf(createCpfGateway, findCpf);
    }

    @Bean
    FindCpf findCpf(FindCpfGateway findClientByCpfGateway) {
        return new FindCpf(findClientByCpfGateway);
    }

    @Bean
    CreateCpfGateway createCpfGateway(CpfEntityMapper cpfEntityMapper, CpfRepository cpfRepository) {
        return new CreateCpfRepositoryGateway(cpfEntityMapper, cpfRepository);
    }

    @Bean
    FindCpfGateway findCpfGateway(CpfEntityMapper cpfEntityMapper, CpfRepository cpfRepository) {
        return new SearchCpfRepositoryGateway(cpfEntityMapper, cpfRepository);
    }

    @Bean
    CpfEntityMapper cpfEntityMapper() {
        return new CpfEntityMapper();
    }

}
