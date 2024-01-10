package com.br.fastBurguer.infra.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fastBurguer.adapters.gateways.client.CreateClientGateway;
import com.br.fastBurguer.adapters.gateways.client.FindClientByCpfGateway;
import com.br.fastBurguer.adapters.gateways.client.FindClientByIdGateway;
import com.br.fastBurguer.adapters.presenters.client.ClientDTOMapper;
import com.br.fastBurguer.adapters.presenters.client.ClientEntityMapper;
import com.br.fastBurguer.adapters.presenters.cpf.CpfEntityMapper;
import com.br.fastBurguer.adapters.presenters.email.EmailEntityMapper;
import com.br.fastBurguer.application.useCases.CreateClient;
import com.br.fastBurguer.application.useCases.CreateCpf;
import com.br.fastBurguer.application.useCases.CreateEmail;
import com.br.fastBurguer.application.useCases.FindClientByCpf;
import com.br.fastBurguer.application.useCases.FindClientById;
import com.br.fastBurguer.infra.gateways.client.CreateClientRepositoryGateway;
import com.br.fastBurguer.infra.gateways.client.FindClientByCpfRepositoryGateway;
import com.br.fastBurguer.infra.gateways.client.FindClientByIdRepositoryGateway;
import com.br.fastBurguer.infra.persistence.client.ClientRepository;

@Configuration
public class ClientConfig {

    @Bean
    CreateClient createClient(CreateClientGateway createClientGateway, CreateCpf createCpf, CreateEmail createEmail) {
        return new CreateClient(createClientGateway, createCpf, createEmail);
    }

    @Bean
    FindClientByCpf findClientByCpf(FindClientByCpfGateway findClientByCpfGateway) {
        return new FindClientByCpf(findClientByCpfGateway);
    }

    @Bean
    FindClientById findClientById(FindClientByIdGateway findClientById) {
        return new FindClientById(findClientById);
    }

    @Bean
    CreateClientGateway createClientGateway(ClientRepository clientRepository,
            ClientEntityMapper clientEntityMapper) {
        return new CreateClientRepositoryGateway(clientRepository, clientEntityMapper);
    }

    @Bean
    FindClientByCpfGateway findClientByCpfGateway(ClientEntityMapper clientEntityMapper,
            ClientRepository clientRepository) {
        return new FindClientByCpfRepositoryGateway(clientEntityMapper, clientRepository);
    }

    @Bean
    FindClientByIdGateway findClientByIdGateway(ClientEntityMapper clientEntityMapper,
            ClientRepository clientRepository) {
        return new FindClientByIdRepositoryGateway(clientEntityMapper, clientRepository);
    }

    @Bean
    ClientEntityMapper clientEntityMapper(CpfEntityMapper cpfEntityMapper, EmailEntityMapper emailEntityMapper) {
        return new ClientEntityMapper(cpfEntityMapper, emailEntityMapper);
    }

    @Bean
    ClientDTOMapper clientDTOMapper() {
        return new ClientDTOMapper();
    }
}
