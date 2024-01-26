package com.br.fastBurguer.infra.persistence.client;

import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.infra.persistence.cpf.CpfEntityMapper;
import com.br.fastBurguer.infra.persistence.email.EmailEntityMapper;

public class ClientEntityMapper {

    private final CpfEntityMapper cpfEntityMapper;
    private final EmailEntityMapper emailEntityMapper;

    public ClientEntityMapper(CpfEntityMapper cpfEntityMapper, EmailEntityMapper emailEntityMapper) {
        this.cpfEntityMapper = cpfEntityMapper;
        this.emailEntityMapper = emailEntityMapper;
    }

    public ClientEntity toEntity(Client clientDomain) {
        return new ClientEntity(clientDomain.getName(), cpfEntityMapper.toCpfEntity(clientDomain.getCpf()),
                emailEntityMapper.toEmailEntity(clientDomain.getEmail()),
                clientDomain.getIdentified());
    }

    public Client toDomain(ClientEntity clientEntity) {
        return new Client(clientEntity.getId(), clientEntity.getName(), cpfEntityMapper.toCpfDomain(clientEntity.getCpfEntity()),
                emailEntityMapper.toEmailDomain(clientEntity.getEmailEntity()), clientEntity.getIdentified());
    }

    

    
}
