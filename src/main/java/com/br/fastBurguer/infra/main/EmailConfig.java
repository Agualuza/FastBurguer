package com.br.fastBurguer.infra.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fastBurguer.application.gateways.CreateEmailGateway;
import com.br.fastBurguer.application.useCases.CreateEmail;
import com.br.fastBurguer.infra.gateways.email.CreateEmailRepositoryGateway;
import com.br.fastBurguer.infra.gateways.email.EmailEntityMapper;
import com.br.fastBurguer.infra.persistence.email.EmailRepository;

@Configuration
public class EmailConfig {

    @Bean
    CreateEmail createEmail(CreateEmailGateway createEmailGateway) {
        return new CreateEmail(createEmailGateway);
    }

    @Bean
    CreateEmailGateway createEmailGateway(EmailEntityMapper emailEntityMapper, EmailRepository emailRepository) {
        return new CreateEmailRepositoryGateway(emailEntityMapper, emailRepository);
    }

    @Bean
    EmailEntityMapper emailEntityMapper() {
        return new EmailEntityMapper();
    }
}
