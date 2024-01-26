package com.br.fastBurguer.infra.persistence.email;

import com.br.fastBurguer.core.entities.Email;

public class EmailEntityMapper {

    public EmailEntity toEmailEntity(Email email) {
        return new EmailEntity(email.getAddress());
    }

    public Email toEmailDomain(EmailEntity emailEntity) {
        return new Email(emailEntity.getId(), emailEntity.getAddress());
    }
}
