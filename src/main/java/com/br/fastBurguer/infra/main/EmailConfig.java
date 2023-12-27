package com.br.fastBurguer.infra.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fastBurguer.adapters.ValidateEmailGateway;
import com.br.fastBurguer.application.useCases.CreateEmail;
import com.br.fastBurguer.infra.gateways.email.EmailEntityMapper;
import com.br.fastBurguer.services.ValidateEmailParams;

@Configuration
public class EmailConfig {

    @Bean
    CreateEmail createEmail(ValidateEmailGateway validateEmailGateway) {
        return new CreateEmail(validateEmailGateway);
    }

    @Bean
    ValidateEmailGateway validateEmailGateway() {
        return new ValidateEmailParams();
    }

    @Bean
    EmailEntityMapper emailEntityMapper() {
        return new EmailEntityMapper();
    }
}
