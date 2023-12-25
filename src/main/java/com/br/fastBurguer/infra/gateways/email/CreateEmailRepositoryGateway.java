package com.br.fastBurguer.infra.gateways.email;

import com.br.fastBurguer.application.gateways.CreateEmailGateway;
import com.br.fastBurguer.core.entities.Email;
import com.br.fastBurguer.infra.persistence.email.EmailEntity;
import com.br.fastBurguer.infra.persistence.email.EmailRepository;

public class CreateEmailRepositoryGateway implements CreateEmailGateway {

    private final EmailEntityMapper emailEntityMapper;
    private final EmailRepository emailRepository;

    public CreateEmailRepositoryGateway(EmailEntityMapper emailEntityMapper, EmailRepository emailRepository) {
        this.emailEntityMapper = emailEntityMapper;
        this.emailRepository = emailRepository;
    }

    @Override
    public Email createEmail(Email email) {
       EmailEntity emailEntity = emailEntityMapper.toEntity(email);
       EmailEntity savedObj = emailRepository.save(emailEntity);
       return emailEntityMapper.toDomain(savedObj);
    }
}
