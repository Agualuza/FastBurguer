package com.br.fastBurguer.adapters.presenters.email;

import com.br.fastBurguer.core.entities.Email;
import com.br.fastBurguer.infra.persistence.email.EmailEntity;

public class EmailEntityMapper {

    public EmailEntity toEmailEntity(Email email) {
        return new EmailEntity(email.getAddress());
    }

    public Email toEmailDomain(EmailEntity emailEntity) {
        return new Email(emailEntity.getId(), emailEntity.getAddress());
    }
}
