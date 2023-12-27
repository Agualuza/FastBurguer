package com.br.fastBurguer.adapters.gateways.cpf;

import com.br.fastBurguer.core.entities.Cpf;

public interface FindCpfGateway {
    
    public Cpf findCpf(String number);

}
