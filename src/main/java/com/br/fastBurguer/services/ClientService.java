package com.br.fastBurguer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fastBurguer.domain.client.Client;
import com.br.fastBurguer.domain.client.Enums.ClientIdentifyByEnum;
import com.br.fastBurguer.domain.client.dto.ClientDto;
import com.br.fastBurguer.domain.cpf.CPF;
import com.br.fastBurguer.domain.email.Email;
import com.br.fastBurguer.repository.ClientRepository;
import com.br.fastBurguer.repository.CpfRepository;
import com.br.fastBurguer.repository.EmailRepository;
import com.br.fastBurguer.utils.ConvertCpfParam;
import com.br.fastBurguer.utils.ConvertEmailParams;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CpfRepository cpfRepository;

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    ConvertCpfParam convertCpfParam;

    @Autowired
    ConvertEmailParams convertEmailParams;

    public void clientRegister(ClientDto client) {

        CPF cpf;
        Email email;

        if (client.identified().equals(ClientIdentifyByEnum.NOTIDENTIFY) || (client.identified().equals(ClientIdentifyByEnum.NAME))) {
            cpf = new CPF(null);
        } else {
            cpf = new CPF(convertCpfParam.validateCpfParams(client.cpf().number()));
        }

        cpfRepository.save(cpf);

        if (client.identified().equals(ClientIdentifyByEnum.NAME)) {
            if (convertEmailParams.isEmailValid(client.email().address())) {
                email = new Email(client.email().address());
            } else {
                throw new Error("email inválido");
            }
        } else {
            email = new Email(null);
        }

        emailRepository.save(email);

        Client clientToPersist = new Client(client.name(), cpf, email, client.identified());

        clientRepository.save(clientToPersist);
    }

    public Client getClientByCpf(String cpf) {
        String formatedCpf = convertCpfParam.validateCpfParams(cpf);
        Client clientToReturn = clientRepository.findClientCpf(formatedCpf);
        return clientToReturn;
    }

    public boolean getCpfByNumber(String number) {
        CPF checkCpf = cpfRepository.findByNumber(number);

        return checkCpf == null;
    }
}
