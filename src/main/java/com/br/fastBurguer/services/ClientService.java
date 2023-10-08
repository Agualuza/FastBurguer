package com.br.fastBurguer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fastBurguer.domain.client.Client;
import com.br.fastBurguer.domain.client.dto.ClientDto;
import com.br.fastBurguer.domain.cpf.CPF;
import com.br.fastBurguer.domain.email.Email;
import com.br.fastBurguer.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;
    
    public void clientRegister(ClientDto client) {

        CPF Cpf = new CPF(client.cpf().toString());
        Email email = new Email(client.email().email());

        Client clientToPersist = new Client(client.name(), Cpf, email, client.identified());        
        
        clientRepository.save(clientToPersist);
    }
}
