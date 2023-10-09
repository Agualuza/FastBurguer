package com.br.fastBurguer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fastBurguer.domain.client.Client;
import com.br.fastBurguer.domain.client.dto.ClientDto;
import com.br.fastBurguer.domain.cpf.CPF;
import com.br.fastBurguer.domain.email.Email;
import com.br.fastBurguer.repository.ClientRepository;
import com.br.fastBurguer.repository.CpfRepository;
import com.br.fastBurguer.repository.EmailRepository;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired 
    CpfRepository cpfRepository;

    @Autowired
    EmailRepository emailRepository;
    
    public void clientRegister(ClientDto client) {

        CPF Cpf = new CPF(client.cpf().number());
        cpfRepository.save(Cpf);

        Email email = new Email(client.email().address());
        emailRepository.save(email);

        Client clientToPersist = new Client(client.name(), Cpf, email, client.identified());        
        
        clientRepository.save(clientToPersist);
    }
}
