package com.br.fastBurguer.application.gateways;

import com.br.fastBurguer.core.entities.Email;

public interface CreateEmailGateway {
    
    public Email createEmail(Email email);
}
