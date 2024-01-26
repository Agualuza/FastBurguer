package com.br.fastBurguer.infra.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fastBurguer.adapters.gateways.cpf.FindCpfGateway;
import com.br.fastBurguer.adapters.gateways.cpf.ValidateCpfGateway;
import com.br.fastBurguer.application.useCases.CreateCpf;
import com.br.fastBurguer.application.useCases.FindCpf;
import com.br.fastBurguer.infra.gateways.cpf.SearchCpfRepositoryGateway;
import com.br.fastBurguer.infra.persistence.cpf.CpfEntityMapper;
import com.br.fastBurguer.infra.persistence.cpf.CpfRepository;
import com.br.fastBurguer.services.ValidateCpf;

@Configuration
public class CpfConfig {

    @Bean
    CreateCpf createCpf(FindCpf findCpf, ValidateCpfGateway validateCpfGateway) {
        return new CreateCpf(findCpf, validateCpfGateway);
    }

    @Bean
    FindCpf findCpf(FindCpfGateway findClientByCpfGateway) {
        return new FindCpf(findClientByCpfGateway);
    }

    @Bean
    ValidateCpfGateway ValidateCpfGateway() {
        return new ValidateCpf();
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
