package com.br.fastBurguer.adapters.presenters.client;

import com.br.fastBurguer.core.entities.Client;
import com.br.fastBurguer.core.entities.Cpf;
import com.br.fastBurguer.core.entities.Email;
import com.br.fastBurguer.infra.persistence.client.ClientEntity;
import com.br.fastBurguer.infra.persistence.cpf.CpfEntity;
import com.br.fastBurguer.infra.persistence.email.EmailEntity;

public class ClientEntityMapper {

    public ClientEntity toEntity(Client clientDomain) {
        return new ClientEntity(clientDomain.getName(), toCpfEntity(clientDomain.getCpf()),
                toEmailEntity(clientDomain.getEmail()),
                clientDomain.getIdentified());
    }

    public Client toDomain(ClientEntity clientEntity) {
        return new Client(clientEntity.getId(), clientEntity.getName(), toCpfDomain(clientEntity.getCpfEntity()),
                toEmailDomain(clientEntity.getEmailEntity()), clientEntity.getIdentified());
    }

    public CpfEntity toCpfEntity(Cpf cpf) {
        return new CpfEntity(cpf.getNumber());
    }

    public Cpf toCpfDomain(CpfEntity cpfEntity) {
        return new Cpf(cpfEntity.getNumber());
    }

    public EmailEntity toEmailEntity(Email email) {
        return new EmailEntity(email.getAddress());
    }

    public Email toEmailDomain(EmailEntity emailEntity) {
        return new Email(emailEntity.getAddress());
    }
}
