package com.br.fastBurguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fastBurguer.domain.client.dto.ClientDto;
import com.br.fastBurguer.services.ClientService;

@RestController
@RequestMapping("/clientRegister")
public class ClientController {
    
    @Autowired
    ClientService clientService;

    @PostMapping()
    public void clientRegister(@RequestBody ClientDto client) {
        System.out.println(client);
        clientService.clientRegister(client);
    }
}
