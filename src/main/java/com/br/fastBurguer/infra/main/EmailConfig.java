package com.br.fastBurguer.infra.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fastBurguer.application.useCases.CreateEmail;
import com.br.fastBurguer.infra.gateways.email.EmailEntityMapper;

@Configuration
public class EmailConfig {

    @Bean
    CreateEmail createEmail() {
        return new CreateEmail();
    }

    @Bean
    EmailEntityMapper emailEntityMapper() {
        return new EmailEntityMapper();
    }
}
