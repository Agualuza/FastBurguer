package com.br.fastBurguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.fastBurguer.domain.client.Client;
import com.br.fastBurguer.domain.client.dto.ClientDto;
import com.br.fastBurguer.services.ClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/client")
public class ClientController {
    
    @Autowired
    ClientService clientService;

    @PostMapping()
    public void clientRegister(@RequestBody ClientDto client) {
        System.out.println(client);
        clientService.clientRegister(client);
    }

    @GetMapping()
    public String getClientByCpf(@RequestParam("cpf") String cpfValue) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Client clientToReturn = clientService.getClientByCpf(cpfValue);
        String json = objectMapper.writeValueAsString(clientToReturn);
        return json;
    }
}
