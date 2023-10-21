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
import com.br.fastBurguer.utils.ConvertCpfParam;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    ConvertCpfParam convertCpfParam;

    @Operation(summary = "Create Client")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Client Created",
            content = {
                @Content(mediaType = "application/json",
                schema = @Schema(implementation = ClientDto.class))
            }
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Bad Request",
            content = {
                @Content
            }
        )
    })
    @PostMapping()
    public ResponseEntity<String> clientRegister(@RequestBody ClientDto client) {
        if (!clientService.getCpfByNumber(client.cpf().number())) {
            System.out.println("Cliente já existe");
            return ResponseEntity.badRequest().body("CPF já existe");
        }
        clientService.clientRegister(client);
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "Search Client By CPF")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Client Found",
            content = {
                @Content
            }
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Bad Request",
            content = {
                @Content
            }
        )
    })
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
