package com.br.fastBurguer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.fastBurguer.domain.client.Client;
import com.br.fastBurguer.domain.client.dto.ClientDto;
import com.br.fastBurguer.domain.client.dto.ClientResponseControllerDto;
import com.br.fastBurguer.services.ClientService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping()
    public ResponseEntity<ClientDto> clientRegister(@RequestBody ClientDto client) {
        clientService.clientRegister(client);
        return ResponseEntity.ok(client);
    }

    @GetMapping()
    public ResponseEntity<ClientResponseControllerDto> getClientByCpf(@RequestParam("cpf") String cpfValue)
            throws JsonProcessingException {

        Client clientToReturn = clientService.getClientByCpf(cpfValue);

        if (clientToReturn != null) {
            ClientResponseControllerDto clientDto = new ClientResponseControllerDto(clientToReturn.getId(),
                    clientToReturn.getCpf().getNumber(), clientToReturn.getEmail().getAddress(), clientToReturn.getIdentified());
            return ResponseEntity.ok(clientDto);
        }

        return ResponseEntity.notFound().build();
    }
}
