package com.br.fastBurguer.adapters.presenters.email;

import com.br.fastBurguer.core.entities.Email;
import com.br.fastBurguer.infra.persistence.email.EmailEntity;

public class EmailEntityMapper {

    public EmailEntity toEntity(Email emailDomain) {
        return new EmailEntity(emailDomain.getAddress());
    }

    public Email toDomain(EmailEntity emailEntity) {
        return new Email(emailEntity.getAddress());
    }
}
