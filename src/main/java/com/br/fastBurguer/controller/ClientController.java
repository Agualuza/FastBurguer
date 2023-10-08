package com.br.fastBurguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.fastBurguer.domain.client.dto.ClientDto;
import com.br.fastBurguer.services.ClientService;

@Controller
@RequestMapping("/clientRegister")
public class ClientController {
    
    @Autowired
    ClientService clientService;

    @PostMapping()
    public void clientRegister(@RequestBody ClientDto client) {
        clientService.clientRegister(client);
    }
}
