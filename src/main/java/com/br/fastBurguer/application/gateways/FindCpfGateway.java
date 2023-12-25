package com.br.fastBurguer.application.gateways;

import com.br.fastBurguer.core.entities.Cpf;

public interface FindCpfGateway {
    
    public Cpf findCpf(String number);

}
